/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author phatl
 */
public class NhanVienDAO {

    Connection connection;
    PreparedStatement pst;

    public NhanVienDTO selectNhanVienByMaNV(int manv) {
        NhanVienDTO result = null;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "SELECT * FROM nhanvien WHERE manv=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, manv);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int maNV = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                int gioitinh = rs.getInt("gioitinh");
                Date ngaySinh = rs.getDate("ngaysinh");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                int trangthai = rs.getInt("trangthai");
                result = new NhanVienDTO(maNV, hoten, gioitinh, ngaySinh, sdt, trangthai, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySQLConnection.closeConnection(connection);
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
