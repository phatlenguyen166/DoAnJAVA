package DAO;

import DTO.PhieuNhapDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.logging.Level;

public class PhieuNhapDAO {

    private Connection connection;
    private PreparedStatement ps;


    // Phương thức để lấy thời gian hiện tại
    private LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public void insertPhieuNhap(PhieuNhapDTO phieuNhapDTO, long now) {
        try {
            Timestamp currentTime = new Timestamp(now); // Tạo đối tượng Timestamp từ giá trị now
            // Chèn dữ liệu vào cơ sở dữ liệu
            String sql = "INSERT INTO phieunhap (thoigian, manhacungcap, manv, tongtien, trangthai) VALUES (?, ?, ?, ?, 1)";
            connection = MySQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, currentTime); // Sử dụng currentTime thay vì Timestamp.valueOf(currentTime)
            ps.setInt(2, phieuNhapDTO.getManhacungcap());
            ps.setInt(3, phieuNhapDTO.getMaNV());
            ps.setLong(4, phieuNhapDTO.getTongTien());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi theo nhu cầu của bạn
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
        ArrayList<PhieuNhapDTO> listPhieuNhap = new ArrayList<>();
        String sql = "SELECT maphieunhap, thoigian, manhacungcap, manv, tongtien FROM phieunhap WHERE trangthai = 1"; // Lấy những phiếu nhập có trạng thái là 1
        try{
            connection = MySQLConnection.getConnection();
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuNhapDTO phieuNhapDTO = new PhieuNhapDTO();
                phieuNhapDTO.setMaphieunhap(rs.getInt("maphieunhap"));
                // Lấy thời gian từ ResultSet dưới dạng long
                long timeInMillis = rs.getTimestamp("thoigian").getTime();
                // Tạo đối tượng java.sql.Timestamp từ thời gian dưới dạng long
                Timestamp timestamp = new Timestamp(timeInMillis);
                phieuNhapDTO.setThoigiantao(timestamp);

                phieuNhapDTO.setManhacungcap(rs.getInt("manhacungcap"));
                phieuNhapDTO.setMaNV(rs.getInt("manv"));
                phieuNhapDTO.setTongTien(rs.getLong("tongtien"));
                listPhieuNhap.add(phieuNhapDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý hoặc thông báo lỗi theo nhu cầu của bạn
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listPhieuNhap;
    }

    public PhieuNhapDTO selectById(int mapn) {
        PhieuNhapDTO result = null;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "SELECT * FROM phieunhap WHERE maphieunhap=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mapn);
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int maphieunhap = rs.getInt("maphieunhap");
                long timeInMillis = rs.getTimestamp("thoigian").getTime();
                // Tạo đối tượng java.sql.Timestamp từ thời gian dưới dạng long
                Timestamp timestamp = new Timestamp(timeInMillis);
                int mancc = rs.getInt("manhacungcap");
                int nguoitao = rs.getInt("manv");
                long tongtien = rs.getLong("tongtien");
                int trangthai = rs.getInt("trangthai");
                result = new PhieuNhapDTO(maphieunhap, timestamp, mancc, nguoitao, tongtien, trangthai);
            }
            MySQLConnection.closeConnection(connection);
        } catch (SQLException e) {
        }
        return result;
    }
    
    //Lẫy mã phiếu nhập
    public int getLatestMaPhieuNhap() {
        connection = MySQLConnection.getConnection();
        // Truy vấn cơ sở dữ liệu để lấy mã phiếu nhập lớn nhất đã được tạo
        String sql = "SELECT MAX(maphieunhap) FROM phieunhap";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Trả về mã phiếu nhập lớn nhất
            }
        } catch (SQLException ex) {
        }
        return 0; // Trả về 0 nếu không có mã phiếu nhập nào tồn tại
    }
    
    public boolean DeletePhieuNhap(int mapn){
        boolean thanhcong = false;
        try{
            connection = MySQLConnection.getConnection();
            String sql = "UPDATE phieunhap SET trangthai = 0 WHERE maphieunhap = ?";
            ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setInt(1, mapn);
            int result = ps.executeUpdate();
            if(result > 0){
                thanhcong = true;
            }
            MySQLConnection.closeConnection(connection);
        } catch(SQLException ex){
            java.util.logging.Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thanhcong;
    }
}
