package GUI;

import GUI.ThuocTinhSP.Loai;
import GUI.ThuocTinhSP.ThuongHieu;
import GUI.ThuocTinhSP.XuatXu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class ThuocTinh extends javax.swing.JPanel {

    /**
     * Creates new form ThuocTinh
     */
    ThuongHieu thuongHieu ;
    Loai loai;
    XuatXu xuatXu;
    Color BackgroundColor = new Color(240, 247, 250);

    public ThuocTinh() {
        initComponents();
//        contentCenter.setLayout(new BorderLayout()); // Thiết lập layout cho contentCenter
//        btnThuongHieuActionPerformed(null);
        

        
        tabPaneThuocTinh.setOpaque(false);
        tabPaneThuocTinh.setOpaque(false);
        this.setBackground(BackgroundColor);
        
        thuongHieu = new ThuongHieu();
        loai = new Loai();
        xuatXu = new XuatXu();
        tabPaneThuocTinh.addTab("Thương hiệu", thuongHieu);
        tabPaneThuocTinh.addTab("Loại", loai);
        tabPaneThuocTinh.addTab("Xuất xứ", xuatXu);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPaneThuocTinh = new javax.swing.JTabbedPane();

        setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneThuocTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPaneThuocTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addPanel(Container contentCenter, JPanel panel) {
        panel.setSize(contentCenter.getSize());
        contentCenter.removeAll();
        contentCenter.add(panel).setVisible(true);
        contentCenter.revalidate();
        contentCenter.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabPaneThuocTinh;
    // End of variables declaration//GEN-END:variables
}
