package GUI;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class TaiKhoan extends javax.swing.JPanel {

    /**
     * Creates new form TaiKhoan
     */
    Color BackgroundColor = new Color(240, 247, 250);
    public TaiKhoan() {
        
        initComponents();
        addIcon();
        tblTaiKhoan.setFocusable(false);     
        tblTaiKhoan.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblTaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblTaiKhoan.setFocusable(false);
        tblTaiKhoan.setAutoCreateRowSorter(true);
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        pnlCenter.setBackground(BackgroundColor);
        pnlCenter.setBorder(new EmptyBorder(20,0,0,0));
    }
    private void addIcon(){
            btnThemTK.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSuaTK.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoaTK.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnNhapExcelTK.setIcon(new FlatSVGIcon("./icon/import_excel.svg"));
            btnXuatExcelTK.setIcon(new FlatSVGIcon("./icon/export_excel.svg"));

        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        btnThemTK = new javax.swing.JButton();
        btnSuaTK = new javax.swing.JButton();
        btnXoaTK = new javax.swing.JButton();
        btnNhapExcelTK = new javax.swing.JButton();
        btnXuatExcelTK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JTextField();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 800));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setPreferredSize(new java.awt.Dimension(1200, 70));

        btnThemTK.setText("Thêm");
        pnlTop.add(btnThemTK);

        btnSuaTK.setText("Sửa");
        btnSuaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnSuaTK);

        btnXoaTK.setText("Xóa");
        btnXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnXoaTK);

        btnNhapExcelTK.setText("Nhập excel");
        btnNhapExcelTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnNhapExcelTK);

        btnXuatExcelTK.setText("Xuất excel");
        btnXuatExcelTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelTKActionPerformed(evt);
            }
        });
        pnlTop.add(btnXuatExcelTK);

        jLabel1.setText("Tìm kiếm :");
        pnlTop.add(jLabel1);

        btnTimKiem.setPreferredSize(new java.awt.Dimension(200, 30));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        pnlTop.add(btnTimKiem);

        add(pnlTop, java.awt.BorderLayout.NORTH);

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null},
                {"1", null, null, null},
                {"1", null, null, null},
                {"1", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, "1", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {"1", null, null, null},
                {"1", null, null, null},
                {"1", null, null, null},
                {"1", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {"1", null, null, null}
            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Nhóm quyền", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(tblTaiKhoan);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaTKActionPerformed

    private void btnXoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaTKActionPerformed

    private void btnNhapExcelTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExcelTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhapExcelTKActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXuatExcelTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelTKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapExcelTK;
    private javax.swing.JButton btnSuaTK;
    private javax.swing.JButton btnThemTK;
    private javax.swing.JTextField btnTimKiem;
    private javax.swing.JButton btnXoaTK;
    private javax.swing.JButton btnXuatExcelTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
