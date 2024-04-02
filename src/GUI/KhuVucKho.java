package GUI;

import com.formdev.flatlaf.extras.FlatSVGIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class KhuVucKho extends javax.swing.JPanel {

    /**
     * Creates new form KhuVucKho
     */
    public KhuVucKho() {
        initComponents();
        setSize(1200,800);
        addIcon();
        tblKho.setFocusable(false);     
        tblKho.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
        tblKho.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblKho.setFocusable(false);
        tblKho.setAutoCreateRowSorter(true);
    }

    private void addIcon(){
            btnThemKho.setIcon(new FlatSVGIcon("./icon/add.svg"));
            btnSuaKho.setIcon(new FlatSVGIcon("./icon/edit.svg"));
            btnXoaKho.setIcon(new FlatSVGIcon("./icon/delete.svg"));
            btnNhapExcelKho.setIcon(new FlatSVGIcon("./icon/detail.svg"));
            btnXuatExcelKho.setIcon(new FlatSVGIcon("./icon/import_excel.svg"));

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTop = new javax.swing.JPanel();
        btnThemKho = new javax.swing.JButton();
        btnSuaKho = new javax.swing.JButton();
        btnXoaKho = new javax.swing.JButton();
        btnXuatExcelKho = new javax.swing.JButton();
        btnNhapExcelKho = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        btnTimKiem61 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKho = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        panelTop.setBackground(new java.awt.Color(255, 255, 255));
        panelTop.setPreferredSize(new java.awt.Dimension(1200, 70));

        btnThemKho.setText("Thêm");
        btnThemKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhoActionPerformed(evt);
            }
        });
        panelTop.add(btnThemKho);

        btnSuaKho.setText("Sửa");
        panelTop.add(btnSuaKho);

        btnXoaKho.setText("Xóa");
        panelTop.add(btnXoaKho);

        btnXuatExcelKho.setText("Xuất excel");
        panelTop.add(btnXuatExcelKho);

        btnNhapExcelKho.setText("Nhập excel");
        panelTop.add(btnNhapExcelKho);

        jLabel62.setText("Tìm kiếm :");
        panelTop.add(jLabel62);

        btnTimKiem61.setPreferredSize(new java.awt.Dimension(200, 30));
        btnTimKiem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem61ActionPerformed(evt);
            }
        });
        panelTop.add(btnTimKiem61);

        add(panelTop, java.awt.BorderLayout.NORTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 700));

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã kho", "Tên khu vực", "Ghi chú"
            }
        ));
        jScrollPane1.setViewportView(tblKho);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemKhoActionPerformed

    private void btnTimKiem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiem61ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapExcelKho;
    private javax.swing.JButton btnSuaKho;
    private javax.swing.JButton btnThemKho;
    private javax.swing.JTextField btnTimKiem61;
    private javax.swing.JButton btnXoaKho;
    private javax.swing.JButton btnXuatExcelKho;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tblKho;
    // End of variables declaration//GEN-END:variables
}
