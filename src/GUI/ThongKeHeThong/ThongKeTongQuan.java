/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThongKeHeThong;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author phatl
 */
public class ThongKeTongQuan extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeTongQuan
     */
    public ThongKeTongQuan() {
        initComponents();
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        tblThongKe.setFocusable(false);
        tblThongKe.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlTableThongKe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout(10, 10));

        pnlTop.setBackground(new java.awt.Color(255, 0, 0));
        pnlTop.setPreferredSize(new java.awt.Dimension(0, 120));
        pnlTop.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlTop.add(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlTop.add(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        pnlTop.add(jPanel3);

        add(pnlTop, java.awt.BorderLayout.NORTH);

        pnlCenter.setBackground(new java.awt.Color(51, 204, 255));
        pnlCenter.setPreferredSize(new java.awt.Dimension(200, 800));

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 995, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlTableThongKe.setBackground(new java.awt.Color(0, 204, 0));
        pnlTableThongKe.setPreferredSize(new java.awt.Dimension(317, 200));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ngày", "Vốn", "Doanh thu", "Lợi nhuận"
            }
        ));
        jScrollPane1.setViewportView(tblThongKe);

        javax.swing.GroupLayout pnlTableThongKeLayout = new javax.swing.GroupLayout(pnlTableThongKe);
        pnlTableThongKe.setLayout(pnlTableThongKeLayout);
        pnlTableThongKeLayout.setHorizontalGroup(
            pnlTableThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        pnlTableThongKeLayout.setVerticalGroup(
            pnlTableThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableThongKeLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(pnlTableThongKe, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlTableThongKe;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblThongKe;
    // End of variables declaration//GEN-END:variables
}
