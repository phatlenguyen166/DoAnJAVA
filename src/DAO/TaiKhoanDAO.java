/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phatl
 */
public class TaiKhoanDAO {

    Connection connection;
    PreparedStatement pst;

    public TaiKhoanDTO selectByUser(String t) {
        TaiKhoanDTO result = null;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE tendangnhap=?";
            pst = connection.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int manv = rs.getInt("manv");
                String tendangnhap = rs.getString("tendangnhap");
                String matkhau = rs.getString("matkhau");
                int trangthai = rs.getInt("trangthai");
                int manhomquyen = rs.getInt("manhomquyen");
                TaiKhoanDTO tk = new TaiKhoanDTO(manv, tendangnhap, matkhau, manhomquyen, trangthai);
                result = tk;
            }
            MySQLConnection.closeConnection(connection);
        } catch (SQLException e) {
        }
        return result;
    }

    public String selectChucVu(int maquyen) {
        String result = null;
        try {
            connection = MySQLConnection.getConnection();
            String sql = "SELECT * FROM nhomquyen WHERE manhomquyen=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, maquyen);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                String tennhomquyen = rs.getString("tennhomquyen");
                result = tennhomquyen;
            }
            MySQLConnection.closeConnection(connection);
        } catch (SQLException e) {
        }
        return result;
    }
}
