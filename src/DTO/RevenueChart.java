/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author phatl
 */
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.*;
import java.sql.*;
import org.jfree.chart.plot.PlotOrientation;

public class RevenueChart extends JFrame {

    public RevenueChart() {
        setTitle("Biểu đồ doanh thu");
        setSize(800, 600);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Kết nối đến cơ sở dữ liệu
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlycuahanggiay", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MONTH(thoigian) AS month, SUM(tongtien) AS revenue FROM phieunhap GROUP BY MONTH(thoigian)");

            while (resultSet.next()) {
                int month = resultSet.getInt("month");
                double revenue = resultSet.getDouble("revenue");
                dataset.addValue(revenue, "Doanh thu", "Tháng " + month);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh thu theo tháng", // Tiêu đề biểu đồ
                "Tháng", // Nhãn trục x
                "Doanh thu (VNĐ)", // Nhãn trục y
                dataset, // Dataset chứa dữ liệu
                PlotOrientation.VERTICAL, // Hướng của biểu đồ (dọc hoặc ngang)
                true, // Có hiển thị hoặc ẩn legend
                true, // Có hiển thị hoặc ẩn tooltip
                false // Có hiển thị hoặc ẩn URL
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        add(chartPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RevenueChart revenueChart = new RevenueChart();
            revenueChart.setVisible(true);
        });
    }
}
