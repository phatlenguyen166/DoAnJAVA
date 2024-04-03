package GUI;

import GUI.Panel.TaoPhieuNhap;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class PhieuNhap extends javax.swing.JPanel {

    public PhieuNhap() {
    initComponents();
   
    addIcon();
    tblPhieuNhap.setFocusable(false);     
    tblPhieuNhap.setDefaultEditor(Object.class, null);
    tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(180);
    tblPhieuNhap.setFocusable(false);
    tblPhieuNhap.setAutoCreateRowSorter(true);
}

    
    private void addIcon(){
            btnThemPN.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnChiTietPN.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnHuyPhieu.setIcon(new FlatSVGIcon("./icon/cancel.svg"));
            btnXuatExcelPN.setIcon(new FlatSVGIcon("./icon/export_excel.svg"));

        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        mainContentPN = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        btnThemPN = new javax.swing.JButton();
        btnChiTietPN = new javax.swing.JButton();
        btnHuyPhieu = new javax.swing.JButton();
        btnXuatExcelPN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        scpnlshow = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        pnlLoc = new javax.swing.JPanel();
        txtnhacungcap = new javax.swing.JLabel();
        comboboxNCC = new javax.swing.JComboBox<>();
        txtnhacungcap1 = new javax.swing.JLabel();
        txtnhacungcap2 = new javax.swing.JLabel();
        comboboxNCC2 = new javax.swing.JComboBox<>();
        txtnhacungcap3 = new javax.swing.JLabel();
        txtnhacungcap4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtnhacungcap5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        mainContentPN.setPreferredSize(new java.awt.Dimension(1300, 800));
        mainContentPN.setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setPreferredSize(new java.awt.Dimension(1200, 70));

        btnThemPN.setText("Thêm");
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnThemPN);

        btnChiTietPN.setText("Chi tiết");
        btnChiTietPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnChiTietPN);

        btnHuyPhieu.setText("Hủy phiếu");
        btnHuyPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhieuActionPerformed(evt);
            }
        });
        pnlTop.add(btnHuyPhieu);

        btnXuatExcelPN.setText("Xuất excel");
        btnXuatExcelPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnXuatExcelPN);

        jLabel1.setText("Tìm kiếm :");
        pnlTop.add(jLabel1);

        btnTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnlTop.add(btnTimKiem);

        mainContentPN.add(pnlTop, java.awt.BorderLayout.PAGE_START);

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã xuất phiếu", "Nhà cung cấp", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        scpnlshow.setViewportView(tblPhieuNhap);

        pnlLoc.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoc.setPreferredSize(new java.awt.Dimension(270, 700));

        txtnhacungcap.setText("Nhân viên nhập");

        comboboxNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        txtnhacungcap1.setText("Đến số tiền (VND)");

        txtnhacungcap2.setText("Từ ngày");

        comboboxNCC2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        txtnhacungcap3.setText("Đến ngày");

        txtnhacungcap4.setText("Nhà cung cấp");

        txtnhacungcap5.setText("Từ số tiền (VND)");

        javax.swing.GroupLayout pnlLocLayout = new javax.swing.GroupLayout(pnlLoc);
        pnlLoc.setLayout(pnlLocLayout);
        pnlLocLayout.setHorizontalGroup(
            pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField2)
                    .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1)
                            .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxNCC, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnhacungcap2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnhacungcap1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboboxNCC2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 248, Short.MAX_VALUE))
                                .addComponent(txtnhacungcap3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtnhacungcap4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnhacungcap5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlLocLayout.setVerticalGroup(
            pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnhacungcap4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxNCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(txtnhacungcap3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(txtnhacungcap5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpnlshow, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addComponent(scpnlshow))
                .addContainerGap())
        );

        mainContentPN.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(mainContentPN, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXuatExcelPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelPNActionPerformed

    private void btnHuyPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyPhieuActionPerformed

    private void btnChiTietPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChiTietPNActionPerformed

    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed
        pnlLoc.setVisible(false);
        pnlTop.setVisible(false);
        scpnlshow.setVisible(false);
        // Tạo một thể hiện của panel từ file java khác
        TaoPhieuNhap taoPhieuNhap = new TaoPhieuNhap();
        //        mainContentPN.add(taoPhieuNhap, BorderLayout.CENTER);
        mainContentPN.add(taoPhieuNhap); // Thêm panel vào mainContentPN
        mainContentPN.revalidate(); // Cập nhật giao diện
        mainContentPN.repaint(); // Vẽ lại giao diện để hiển thị panel mới

    }//GEN-LAST:event_btnThemPNActionPerformed
    private void removepanel(Component component){
    if (component != null) {
        remove(component);
        revalidate();
        repaint();
    }
}
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietPN;
    private javax.swing.JButton btnHuyPhieu;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JTextField btnTimKiem;
    private javax.swing.JButton btnXuatExcelPN;
    private javax.swing.JComboBox<String> comboboxNCC;
    private javax.swing.JComboBox<String> comboboxNCC2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel mainContentPN;
    private javax.swing.JPanel pnlLoc;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane scpnlshow;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JLabel txtnhacungcap;
    private javax.swing.JLabel txtnhacungcap1;
    private javax.swing.JLabel txtnhacungcap2;
    private javax.swing.JLabel txtnhacungcap3;
    private javax.swing.JLabel txtnhacungcap4;
    private javax.swing.JLabel txtnhacungcap5;
    // End of variables declaration//GEN-END:variables
}
