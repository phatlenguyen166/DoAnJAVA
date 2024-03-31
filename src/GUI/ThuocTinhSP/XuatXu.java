/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuocTinhSP;

import BUS.XuatXuBUS;
import DTO.ThuocTinhSanPham.XuatXuDTO;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phatl
 */
public class XuatXu extends javax.swing.JPanel {

    /**
     * Creates new form XuatXu
     */
    public XuatXu() {
        initComponents();
        hienThiListXuatXu();
        lblXuatXu.setFont(new Font("Tahoma", Font.BOLD, 20));
        tblXuatXu.setFocusable(false);
        tblXuatXu.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table

        tblXuatXu.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            chonDongTrongBang();
        });
    }

    private void chonDongTrongBang() {
        int selectedRow = tblXuatXu.getSelectedRow();
        if (selectedRow != -1) {
            String tenXuatXu = tblXuatXu.getValueAt(selectedRow, 1).toString(); // Thay đổi tên biến
            txtTenXuatXu.setText(tenXuatXu); // Thay đổi tên biến
        }
    }

    private void hienThiListXuatXu() { // Thay đổi tên phương thức
        XuatXuBUS xuatXuBUS = new XuatXuBUS(); // Thay đổi tên biến
        ArrayList<XuatXuDTO> listXuatXu = xuatXuBUS.getAllXuatXu(); // Thay đổi tên biến
        DefaultTableModel model = (DefaultTableModel) tblXuatXu.getModel();
        model.setRowCount(0);
        for (XuatXuDTO xuatXu : listXuatXu) { // Thay đổi tên biến
            Object[] row = {xuatXu.getMaxuatxu(), xuatXu.getTenxuatxu()}; // Thay đổi tên biến
            model.addRow(row);
        }
    }

    private void themXuatXu() {
        String tenXuatXuThem = txtTenXuatXu.getText().trim();
        if (!tenXuatXuThem.isEmpty()) {
            XuatXuDTO xuatXuDTO = new XuatXuDTO();
            xuatXuDTO.setTenxuatxu(tenXuatXuThem);
            XuatXuBUS xuatXuBUS = new XuatXuBUS(); // Thay đổi tên biến và khởi tạo đối tượng
            boolean thanhCong = xuatXuBUS.themXuatXu(xuatXuDTO); // Thay đổi tên phương thức và gọi phương thức thêm xuất xứ
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Thêm xuất xứ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiListXuatXu(); // Thay đổi tên phương thức
                txtTenXuatXu.setText(""); // Xóa dữ liệu trong ô nhập liệu
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên xuất xứ", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void suaXuatXu() {
        int selectedRow = tblXuatXu.getSelectedRow();
        if (selectedRow != -1) {
            int maxuatxu = (int) tblXuatXu.getValueAt(selectedRow, 0);
            String tenXuatXuMoi = txtTenXuatXu.getText();
            XuatXuDTO xuatXuDTO = new XuatXuDTO();
            xuatXuDTO.setMaxuatxu(maxuatxu);
            xuatXuDTO.setTenxuatxu(tenXuatXuMoi);
            XuatXuBUS xuatXuBUS = new XuatXuBUS();
            boolean thanhCong = xuatXuBUS.suaXuatXu(xuatXuDTO);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin xuất xứ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiListXuatXu();
                txtTenXuatXu.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một xuất xứ để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void xoaXuatXu() {
        int selectedRow = tblXuatXu.getSelectedRow();
        if (selectedRow != -1) {
            int maxuatxu = (int) tblXuatXu.getValueAt(selectedRow, 0);
            XuatXuBUS xuatXuBUS = new XuatXuBUS();
            boolean thanhCong = xuatXuBUS.xoaXuatXu(maxuatxu);
            if (thanhCong) {
                txtTenXuatXu.setText("");
                JOptionPane.showMessageDialog(null, "Đã xóa xuất xứ thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiListXuatXu();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một xuất xứ để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenXuatXu = new javax.swing.JTextField();
        btnThemXuatXu = new javax.swing.JButton();
        btnSuaXuatXu = new javax.swing.JButton();
        btnXoaXuatXu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblXuatXu = new javax.swing.JTable();
        title = new javax.swing.JPanel();
        lblXuatXu = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tên xuất xứ :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnThemXuatXu.setText("Thêm");
        btnThemXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuatXuActionPerformed(evt);
            }
        });

        btnSuaXuatXu.setText("Sửa");
        btnSuaXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaXuatXuActionPerformed(evt);
            }
        });

        btnXoaXuatXu.setText("Xóa");
        btnXoaXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXuatXuActionPerformed(evt);
            }
        });

        tblXuatXu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã xuất xứ", "Tên xuất xứ"
            }
        ));
        jScrollPane1.setViewportView(tblXuatXu);

        title.setBackground(new java.awt.Color(0, 102, 255));
        title.setForeground(new java.awt.Color(255, 255, 255));

        lblXuatXu.setForeground(new java.awt.Color(255, 255, 255));
        lblXuatXu.setText("XUẤT XỨ SẢN PHẨM");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(426, 426, 426)
                .addComponent(lblXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblXuatXu)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemXuatXu)
                    .addComponent(btnXoaXuatXu)
                    .addComponent(btnSuaXuatXu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnThemXuatXu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaXuatXu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaXuatXu)
                        .addGap(0, 246, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuatXuActionPerformed
        // TODO add your handling code here:
        themXuatXu();
    }//GEN-LAST:event_btnThemXuatXuActionPerformed

    private void btnSuaXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaXuatXuActionPerformed
        // TODO add your handling code here:
        suaXuatXu();
    }//GEN-LAST:event_btnSuaXuatXuActionPerformed

    private void btnXoaXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXuatXuActionPerformed
        // TODO add your handling code here:
        xoaXuatXu();
    }//GEN-LAST:event_btnXoaXuatXuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaXuatXu;
    private javax.swing.JButton btnThemXuatXu;
    private javax.swing.JButton btnXoaXuatXu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblXuatXu;
    private javax.swing.JTable tblXuatXu;
    private javax.swing.JPanel title;
    private javax.swing.JTextField txtTenXuatXu;
    // End of variables declaration//GEN-END:variables
}
