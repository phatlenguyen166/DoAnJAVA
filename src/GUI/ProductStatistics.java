/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ProductStatistics extends JFrame {
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public ProductStatistics() {
        setTitle("Product Statistics");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Units Sold");

        resultTable = new JTable(tableModel);
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(resultTable);

        add(scrollPane, BorderLayout.CENTER);

        fetchBestSellingProduct();

        setVisible(true);
    }

    private void fetchBestSellingProduct() {
        String url = "jdbc:mysql://localhost:3306/quanlycuahanggiay";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT sp.masp, sp.tensp, SUM(ct.soluong) AS soluong_ban " +
                         "FROM sanpham sp " +
                         "JOIN ctphieuxuat ct ON sp.masp = ct.masp " +
                         "GROUP BY sp.tensp " +
                         "ORDER BY soluong_ban DESC " +
                         "LIMIT 2";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int masp = resultSet.getInt("masp");
                String tensp = resultSet.getString("tensp");
                int soluongBan = resultSet.getInt("soluong_ban");

                tableModel.addRow(new Object[]{masp, tensp, soluongBan});
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductStatistics::new);
    }
}
