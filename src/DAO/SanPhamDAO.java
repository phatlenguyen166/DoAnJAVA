package DAO;

import DTO.SanPhamDTO;
import DTO.ThuongHieuDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SanPhamDAO {
    Connection connection;
    PreparedStatement pst;
    public SanPhamDAO() {
    }

    public ArrayList<SanPhamDTO> getAllSanPham() {
        ArrayList<SanPhamDTO> listSanPham = new ArrayList<>();
        connection = MySQLConnection.getConnection();
        String query = "SELECT * FROM sanpham WHERE trangthai = 1";
        try {
            pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SanPhamDTO sanPhamDTO = new SanPhamDTO();
                sanPhamDTO.setMasp(rs.getInt("masp"));
                sanPhamDTO.setTensp(rs.getString("tensp"));
                sanPhamDTO.setSize(rs.getInt("size"));
                sanPhamDTO.setTensp(rs.getString("hinhanh"));
                sanPhamDTO.setMasp(rs.getInt("xuatxu"));
                sanPhamDTO.setMasp(rs.getInt("loai"));
                sanPhamDTO.setMasp(rs.getInt("thuonghieu"));
                sanPhamDTO.setMasp(rs.getInt("khuvuckho"));
                sanPhamDTO.setMasp(rs.getInt("soluongton"));
                sanPhamDTO.setMasp(rs.getInt("gianhap"));
                sanPhamDTO.setMasp(rs.getInt("giaxuat"));
                listSanPham.add(sanPhamDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể tải dữ liệu sản phẩm");
        }
        return listSanPham;
    }
}