package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class TrangChu extends javax.swing.JPanel {

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/imgTrangChu.jpg"));

//        Image scaledImage = icon.getImage().getScaledInstance(pnlCenter.getWidth(),  pnlCenter.getHeight(), Image.SCALE_SMOOTH);
        // Đặt ảnh vào JLabel
        Image scaledImg = icon.getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        pnlCenter.setIcon(new ImageIcon(scaledImg));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCenter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel pnlCenter;
    // End of variables declaration//GEN-END:variables
}
