/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThongKeHeThong;
import GUI.ThongKeHeThong.ThongKeTrongThang;
import GUI.ThongKeHeThong.ThongKeTuNgayDenNgay;
import GUI.ThongKeHeThong.ThongKeDoanhThuTungNam;

/**
 *
 * @author phatl
 */
public class ThongKeDoanhThu extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeDoanhThu
     */
    ThongKeDoanhThuTungNam thongKeDoanhThuTungNam = new ThongKeDoanhThuTungNam();
    ThongKeDoanhThuTungThang thongKeDoanhThuTungThang = new ThongKeDoanhThuTungThang();
    ThongKeTrongThang thongKeTrongThang = new ThongKeTrongThang();
    ThongKeTuNgayDenNgay thongKeTuNgayDenNgay = new ThongKeTuNgayDenNgay();
    public ThongKeDoanhThu() {
        initComponents();
        ThongKeDoanhThu.addTab("Thống kê theo năm", thongKeDoanhThuTungNam);
        ThongKeDoanhThu.addTab("Thống kê từng tháng trong năm", thongKeDoanhThuTungThang);
        ThongKeDoanhThu.addTab("Thống kê trong tháng ", thongKeTrongThang);
        ThongKeDoanhThu.addTab("Thống kê từ ngày đến ngày", thongKeTuNgayDenNgay);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ThongKeDoanhThu = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());
        add(ThongKeDoanhThu, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane ThongKeDoanhThu;
    // End of variables declaration//GEN-END:variables
}
