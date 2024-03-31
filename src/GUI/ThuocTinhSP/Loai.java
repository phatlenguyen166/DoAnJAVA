/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuocTinhSP;

import BUS.LoaiBUS;
import BUS.ThuongHieuBUS;
import DTO.LoaiDTO;
import DTO.ThuongHieuDTO;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phatl
 */
public class Loai extends javax.swing.JPanel {

    /**
     * Creates new form ThuongHIeu
     */
    LoaiBUS loaiBUS;
    LoaiDTO loaiDTO;

    public Loai() {
        initComponents();
        lblLoai.setFont(new Font("Tahoma", Font.BOLD, 20));
        hienThiListLoai();
        tblLoai.setFocusable(false);
        tblLoai.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table

        tblLoai.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            chonDongTrongBang();
        });
    }

    private void chonDongTrongBang() {
        int selectedRow = tblLoai.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
            // Lấy giá trị tên thương hiệu từ cột thứ hai (index 1)
            String tenThuongHieu = tblLoai.getValueAt(selectedRow, 1).toString();
            // Đặt giá trị tên thương hiệu vào ô txtTenThuongHieu
            txtTenLoai.setText(tenThuongHieu);
        }
    }

    private void hienThiListLoai() {
        loaiBUS = new LoaiBUS();
        ArrayList<LoaiDTO> listLoai = loaiBUS.getAllLoai();
        DefaultTableModel model = (DefaultTableModel) tblLoai.getModel();
        model.setRowCount(0);
        for (LoaiDTO loai : listLoai) {
            Object[] row = {loai.getMaloai(), loai.getTenloai()};
            model.addRow(row);
        }
    }

    private void suaLoai() {
        int selectedRow = tblLoai.getSelectedRow();
        if (selectedRow != -1) {
            // lấy dữ liệu cần sửa và update tên
            int maLoai = (int) tblLoai.getValueAt(selectedRow, 0);
            String tenThuongLoaiMoi = txtTenLoai.getText();
            // tạo đối tượng DTO;
            loaiDTO = new LoaiDTO();
            loaiDTO.setMaloai(maLoai);
            loaiDTO.setTenloai(tenThuongLoaiMoi);

            loaiBUS = new LoaiBUS();
            boolean thanhCong = loaiBUS.suaLoai(loaiDTO);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin loại thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiListLoai();
                txtTenLoai.setText("");
            } else {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một loại để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void themLoai() {
        String tenLoaiThem = txtTenLoai.getText().trim();
        if (!tenLoaiThem.isEmpty()) {
            loaiDTO = new LoaiDTO();
            loaiDTO.setTenloai(tenLoaiThem);
            loaiBUS = new LoaiBUS();
            boolean thanhCong = loaiBUS.themLoai(loaiDTO);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Thêm thương hiệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Cập nhật lại bảng hoặc danh sách thương hiệu
                hienThiListLoai();
                // Xóa dữ liệu trong ô nhập liệu
                txtTenLoai.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thương hiệu", "Thông báo", JOptionPane.WARNING_MESSAGE);

        }
    }

    private void xoaLoai() {
        int selectedRow = tblLoai.getSelectedRow();
        if (selectedRow != -1) {
            int maLoai = (int) tblLoai.getValueAt(selectedRow, 0);
            loaiBUS = new LoaiBUS();
            
            boolean thanhCong = loaiBUS.xoaLoai(maLoai);
            if (thanhCong) {
                txtTenLoai.setText("");
                JOptionPane.showMessageDialog(null, "Đã xóa thương hiệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                hienThiListLoai();
            } else {
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một thương hiệu để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JPanel();
        lblLoai = new javax.swing.JLabel();
        btnThemLoai = new javax.swing.JButton();
        btnSuaLoai = new javax.swing.JButton();
        btnXoaLoai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoai = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbTenLoai = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();

        title.setBackground(new java.awt.Color(0, 102, 255));
        title.setForeground(new java.awt.Color(255, 255, 255));

        lblLoai.setForeground(new java.awt.Color(255, 255, 255));
        lblLoai.setText("LOẠI SẢN PHẨM");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(439, 439, 439)
                .addComponent(lblLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblLoai)
                .addGap(24, 24, 24))
        );

        btnThemLoai.setText("Thêm");
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        btnSuaLoai.setText("Sửa");
        btnSuaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiActionPerformed(evt);
            }
        });

        btnXoaLoai.setText("Xóa");
        btnXoaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiActionPerformed(evt);
            }
        });

        tblLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã loại", "Tên loại"
            }
        ));
        jScrollPane1.setViewportView(tblLoai);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbTenLoai.setText("Tên loại:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(lbTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(415, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemLoai)
                    .addComponent(btnXoaLoai)
                    .addComponent(btnSuaLoai))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btnThemLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaLoai)
                        .addGap(0, 246, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
        // TODO add your handling code here:
        themLoai();
    }//GEN-LAST:event_btnThemLoaiActionPerformed

    private void btnSuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiActionPerformed
        // TODO add your handling code here:
        suaLoai();
    }//GEN-LAST:event_btnSuaLoaiActionPerformed

    private void btnXoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiActionPerformed
        // TODO add your handling code here:
        xoaLoai();
    }//GEN-LAST:event_btnXoaLoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaLoai;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnXoaLoai;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTenLoai;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JTable tblLoai;
    private javax.swing.JPanel title;
    private javax.swing.JTextField txtTenLoai;
    // End of variables declaration//GEN-END:variables
}
