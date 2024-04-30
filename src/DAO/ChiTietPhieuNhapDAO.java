/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietPhieuNhapDTO;
import DTO.SanPhamDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author this pc
 */
public class ChiTietPhieuNhapDAO {

    Connection connection;
    PreparedStatement ps;

    public ChiTietPhieuNhapDAO() {

    }

    public void insert(ArrayList<ChiTietPhieuNhapDTO> chiTietPhieuNhapList) {
        connection = MySQLConnection.getConnection();
        String sql = "INSERT INTO `ctphieunhap`(`maphieunhap`, `masp`, `soluong`, `dongia`) VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            for (ChiTietPhieuNhapDTO chiTiet : chiTietPhieuNhapList) {
                if (chiTiet != null) {
                    ps.setInt(1, chiTiet.getMaphieunhap());
                    ps.setInt(2, chiTiet.getMasp());
                    ps.setInt(3, chiTiet.getSoluong());
                    ps.setInt(4, chiTiet.getDongia());
                    ps.executeUpdate();
                }
            }
            //MySQLConnection.closeConnection(connection);
        } catch (SQLException ex) {
            //Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi SQL");
        }
    }

    public void updateSoluongton(int masp, int soluong) {
        SanPhamDTO sanpham = new SanPhamDTO();
        int soluongton = sanpham.getSoluongton() + soluong;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "UPDATE sanpham SET soluongton = soluongton + ? WHERE masp = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, soluongton);
                ps.setInt(2, masp);
                System.out.println("check");
                System.out.println(masp);
                System.out.println(soluongton);
                ps.executeUpdate(); // Thực hiện cập nhật
            }
            // MySQLConnection.closeConnection(connection);
            //System.out.println(chiTiet);
        } catch (SQLException e) {
            // Xử lý ngoại lệ
            e.printStackTrace();
        }
    }

    public ArrayList<ChiTietPhieuNhapDTO> selectAll(String t) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM ctphieunhap WHERE maphieunhap = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t);
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                int maphienbansp = rs.getInt("maphienbansp");
                int dongia = rs.getInt("dongia");
                int soluong = rs.getInt("soluong");
                int phuongthucnhap = rs.getInt("hinhthucnhap");
                ChiTietPhieuNhapDTO ctphieu = new ChiTietPhieuNhapDTO(maphieu, maphienbansp, soluong, dongia);
                result.add(ctphieu);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lỗi SQL");
        }
        return result;
    }

    public ChiTietPhieuNhapDTO selectByID(int mapn) {
        ChiTietPhieuNhapDTO result = null;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "SELECT * FROM ctphieunhap WHERE maphieunhap=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mapn);
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int maphieunhap = rs.getInt("maphieunhap");
                int masp = rs.getInt("masp");
                int soluong = rs.getInt("soluong");
                int dongia = rs.getInt("dongia");
                result = new ChiTietPhieuNhapDTO(maphieunhap, masp, soluong, dongia);
            }
            //MySQLConnection.closeConnection(connection);
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<ChiTietPhieuNhapDTO> getAllChiTietPhieuNhap(int mapn) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        connection = MySQLConnection.getConnection(); // Lấy kết nối từ lớp MySQLConnection
        String sql = "SELECT * FROM ctphieunhap WHERE maphieunhap = ?";
        System.out.println(mapn);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, mapn); // Đặt giá trị cho tham số mapn
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                int masp = rs.getInt("masp");
                int dongia = rs.getInt("dongia");
                int soluong = rs.getInt("soluong");
                ChiTietPhieuNhapDTO ctphieu = new ChiTietPhieuNhapDTO(maphieu, masp, soluong, dongia);
                result.add(ctphieu);
                System.out.println(result);
            }
            //MySQLConnection.closeConnection(connection);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi SQL");
            ex.printStackTrace(); // In ra lỗi
        }
        return result;
    }

}
