/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhuVucKhoDTO;
import DTO.LoaiDTO;
import config.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author phatl
 */
public class KhuVucKhoDAO {
    private Connection connection;
    private PreparedStatement pst;

    public KhuVucKhoDAO() {
    }
    
    public ArrayList<KhuVucKhoDTO> gettAllKho() {
        ArrayList<KhuVucKhoDTO> listKho = new ArrayList<>();
        connection = MySQLConnection.getConnection();
        String query = "SELECT * FROM khuvuckho WHERE trangthai = 1";
        try {
            pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                KhuVucKhoDTO khuVucKhoDTO = new KhuVucKhoDTO();
                khuVucKhoDTO.setMakhuvuc(resultSet.getInt("makhuvuc"));
                khuVucKhoDTO.setTenkhuvuc(resultSet.getString("tenkhuvuc"));

                listKho.add(khuVucKhoDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Không thể tải dữ liệu loại");
        }
        return listKho;
    }
    
    
}
