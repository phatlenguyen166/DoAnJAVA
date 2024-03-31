/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThuocTinhSP;

import BUS.ThuongHieuBUS;
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
public class ThuongHieu extends javax.swing.JPanel {

    /**
     * Creates new form ThuongHIeu
     */
    ThuongHieuBUS thuongHieuBUS;
    ThuongHieuDTO thuongHieuDTO;

    public ThuongHieu() {
        initComponents();
        lblLoai.setFont(new Font("Tahoma", Font.BOLD, 20));
        hienThiListThuongHieu();
        tblThuongHieu.setFocusable(false);
        tblThuongHieu.setDefaultEditor(Object.class, null); // set ko cho sửa dữ liệu trên table

        tblThuongHieu.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            chonDongTrongBang();
        });
            
    }

    private void chonDongTrongBang() {
        int selectedRow = tblThuongHieu.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có dòng nào được chọn không
            // Lấy giá trị tên thương hiệu từ cột thứ hai (index 1)
            String tenThuongHieu = tblThuongHieu.getValueAt(selectedRow, 1).toString();
            // Đặt giá trị tên thương hiệu vào ô txtTenThuongHieu
            txtTenThuongHieu.setText(tenThuongHieu);
        }
    }

    private void themThuongHieu() {
        String tenThuongHieuThem = txtTenThuongHieu.getText().trim();
        if (!tenThuongHieuThem.isEmpty()) {
            thuongHieuDTO = new ThuongHieuDTO();
            thuongHieuDTO.setTenthuonghieu(tenThuongHieuThem);
            thuongHieuBUS = new ThuongHieuBUS();
            boolean thanhCong = thuongHieuBUS.themThuongHieu(thuongHieuDTO);
            if (thanhCong) {
                JOptionPane.showMessageDialog(null, "Thêm thương hiệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // Cập nhật lại bảng hoặc danh sách thương hiệu
                hienThiListThuongHieu();
                // Xóa dữ liệu trong ô nhập liệu
                txtTenThuongHieu.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thương hiệu", "Thông báo", JOptionPane.WARNING_MESSAGE);

        }
    }

    private void xoaThuongHieu() {
        int selectedRow = tblThuongHieu.getSelectedRow();
        if (selectedRow != -1) {
            int maThuongHieu = (int) tblThuongHieu.getValueAt(selectedRow, 0);
            thuongHieuBUS = new ThuongHieuBUS();
            
            boolean thanhCong = thuongHieuBUS.xoaThuongHieu(maThuongHieu);
            if (thanhCong) {
                DefaultTableModel model = (DefaultTableModel) tblThuongHieu.getModel();
                model.removeRow(selectedRow);
                txtTenThuongHieu.setText("");
                JOptionPane.showMessageDialog(null, "Đã xóa thương hiệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa thương hiệu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một thương hiệu để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void suaThuongHieu() {
        int selectedRow = tblThuongHieu.getSelectedRow();
        if (selectedRow != -1) {
            // lấy dữ liệu cần sửa và update tên
            int maThuongHieu = (int) tblThuongHieu.getValueAt(selectedRow, 0);
            String tenThuongHieuMoi = txtTenThuongHieu.getText();
            // tạo đối tượng DTO;
            thuongHieuDTO = new ThuongHieuDTO();
            thuongHieuDTO.setMathuonghieu(maThuongHieu);
            thuongHieuDTO.setTenthuonghieu(tenThuongHieuMoi);

            thuongHieuBUS = new ThuongHieuBUS();
            boolean thanhCong = thuongHieuBUS.suaThuongHieu(thuongHieuDTO);
            if (thanhCong) {
                    JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin thương hiệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    hienThiListThuongHieu();
            } else {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một thương hiệu để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    // đổ dữ liệu vào table
    private void hienThiListThuongHieu() {
        thuongHieuBUS = new ThuongHieuBUS();
        ArrayList<ThuongHieuDTO> listThuongHieu = thuongHieuBUS.getAllThuongHieu();
        DefaultTableModel model = (DefaultTableModel) tblThuongHieu.getModel();
        model.setRowCount(0);
        for (ThuongHieuDTO thuongHieu : listThuongHieu) {
            Object[] row = {thuongHieu.getMathuonghieu(), thuongHieu.getTenthuonghieu()};
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThemThuongHieu = new javax.swing.JButton();
        btnSuaThuongHieu = new javax.swing.JButton();
        btnXoaThuongHieu = new javax.swing.JButton();
        scrollThuongHieu = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable();
        title = new javax.swing.JPanel();
        lblLoai = new javax.swing.JLabel();
        tenThuongHieu = new javax.swing.JPanel();
        lblTenThuongHieu = new javax.swing.JLabel();
        txtTenThuongHieu = new javax.swing.JTextField();

        btnThemThuongHieu.setText("Thêm");
        btnThemThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuongHieuActionPerformed(evt);
            }
        });

        btnSuaThuongHieu.setText("Sửa");
        btnSuaThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThuongHieuActionPerformed(evt);
            }
        });

        btnXoaThuongHieu.setText("Xóa");
        btnXoaThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThuongHieuActionPerformed(evt);
            }
        });

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã thương hiệu", "Tên thương hiệu"
            }
        ));
        scrollThuongHieu.setViewportView(tblThuongHieu);

        title.setBackground(new java.awt.Color(0, 102, 255));
        title.setForeground(new java.awt.Color(255, 255, 255));

        lblLoai.setForeground(new java.awt.Color(255, 255, 255));
        lblLoai.setText("THƯƠNG HIỆU SẢN PHẨM");

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(408, 408, 408)
                .addComponent(lblLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblLoai)
                .addGap(24, 24, 24))
        );

        tenThuongHieu.setBackground(new java.awt.Color(255, 255, 255));

        lblTenThuongHieu.setText("Tên thương hiệu :");

        javax.swing.GroupLayout tenThuongHieuLayout = new javax.swing.GroupLayout(tenThuongHieu);
        tenThuongHieu.setLayout(tenThuongHieuLayout);
        tenThuongHieuLayout.setHorizontalGroup(
            tenThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tenThuongHieuLayout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(lblTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tenThuongHieuLayout.setVerticalGroup(
            tenThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tenThuongHieuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tenThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemThuongHieu)
                    .addComponent(btnXoaThuongHieu)
                    .addComponent(btnSuaThuongHieu))
                .addGap(18, 18, 18)
                .addComponent(scrollThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tenThuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollThuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnThemThuongHieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaThuongHieu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaThuongHieu)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThuongHieuActionPerformed
        // TODO add your handling code here: 
        int xacNhan = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?","Xác nhận",JOptionPane.YES_NO_OPTION);
        if (  xacNhan  == JOptionPane.YES_OPTION){
            xoaThuongHieu();
        }
        
    }//GEN-LAST:event_btnXoaThuongHieuActionPerformed

    private void btnSuaThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThuongHieuActionPerformed
        // TODO add your handling code here:
        suaThuongHieu();
    }//GEN-LAST:event_btnSuaThuongHieuActionPerformed

    private void btnThemThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuongHieuActionPerformed
        // TODO add your handling code here:
        themThuongHieu();
    }//GEN-LAST:event_btnThemThuongHieuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaThuongHieu;
    private javax.swing.JButton btnThemThuongHieu;
    private javax.swing.JButton btnXoaThuongHieu;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblTenThuongHieu;
    private javax.swing.JScrollPane scrollThuongHieu;
    private javax.swing.JTable tblThuongHieu;
    private javax.swing.JPanel tenThuongHieu;
    private javax.swing.JPanel title;
    private javax.swing.JTextField txtTenThuongHieu;
    // End of variables declaration//GEN-END:variables
}
