package DAO;

import DTO.SanPhamDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SanPhamDAO {

    public SanPhamDAO() {
    }

    public boolean themSanPham(SanPhamDTO sanPham) {
        String queryThemSP = "INSERT INTO sanpham (tensp, size, hinhanh, xuatxu, loai, thuonghieu, khuvuckho, gianhap, giaxuat) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(queryThemSP)) {
            
            pst.setString(1, sanPham.getTensp());
            pst.setInt(2, sanPham.getSize());
            pst.setString(3, sanPham.getHinhanh());
            pst.setInt(4, sanPham.getXuatxu());
            pst.setInt(5, sanPham.getLoai());
            pst.setInt(6, sanPham.getThuonghieu());
            pst.setInt(7, sanPham.getKhuvuckho());
            pst.setInt(8, sanPham.getGianhap());
            pst.setInt(9, sanPham.getGiaxuat());

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}