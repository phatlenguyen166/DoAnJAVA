/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.SanPhamDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author this pc
 */
public class SanPhamPhieuNhapBUS {
    public static ArrayList<SanPhamDTO> getListSanPham() {
        // Phương thức để lấy danh sách sản phẩm từ cơ sở dữ liệu
        ArrayList<SanPhamDTO> list = new ArrayList<>();
        Connection conn = MySQLConnection.getConnection(); // Lấy kết nối từ lớp MySQLConnection
        String sql = "SELECT masp, tensp, soluongton FROM sanpham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Tạo đối tượng SanPhamDTO từ dữ liệu trả về từ ResultSet
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMasp(rs.getInt("masp"));
                sp.setTensp(rs.getString("tensp"));
                sp.setSoluongton(rs.getInt("soluongton"));
                list.add(sp); // Thêm sản phẩm vào danh sách
            }
            rs.close();
            ps.close();
            MySQLConnection.closeConnection(conn); // Đóng kết nối sau khi sử dụng xong
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
