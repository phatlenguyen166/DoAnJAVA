/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.ThongKeHeThong;

import BUS.ThongKeBUS;
import DTO.ThongKe.ThongKeNccDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author phatl
 */
public class ThongKeNhaCungCap extends javax.swing.JPanel implements ActionListener, KeyListener, PropertyChangeListener{
    ThongKeBUS thongKeBUS;
    ArrayList<ThongKeNccDTO> listnccTH;
    JDateChooser dateStart = new JDateChooser();
    JDateChooser dateEnd = new JDateChooser();
    /**
     * Creates new form ThongKeNhaCungCpa
     */
    public ThongKeNhaCungCap() {
        initComponents();
        thongKeBUS = new ThongKeBUS();
        listnccTH = thongKeBUS.getAllNhaCungCap();
        themDuLieuVaoBang(listnccTH);
        addSelectDate();

        txtnhacungcap.putClientProperty("JTextField.showClearButton", true);
        txtnhacungcap.addKeyListener(this);
        dateStart.addPropertyChangeListener(this);
        dateEnd.addPropertyChangeListener(this);

        tblThongKeNcc.setAutoCreateRowSorter(true);
        tblThongKeNcc.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = tblThongKeNcc.columnAtPoint(e.getPoint());
                if (col == 3 || col == 4) { // Số lượt phiếu và Tổng tiền
                    Collections.sort(listnccTH, (a, b) -> {
                        if (col == 3) {
                            return Integer.compare(a.getSoluong(), b.getSoluong());
                        } else {
                            return Long.compare(a.getTongtien(), b.getTongtien());
                        }
                    });
                    themDuLieuVaoBang(listnccTH);
                }
            }
        });
        
        configureTableColumnSorter(tblThongKeNcc, 4, VND_CURRENCY_COMPARATOR);
    }
    
    public static void configureTableColumnSorter(JTable table, int columnIndex, Comparator<Object> comparator) {
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = (TableRowSorter<DefaultTableModel>) table.getRowSorter();
        if (sorter == null) {
            sorter = new TableRowSorter<>(tblModel);
            table.setRowSorter(sorter);
        }
        sorter.setComparator(columnIndex, comparator);
    }
    
    public Comparator<Object> VND_CURRENCY_COMPARATOR = (Object o1, Object o2) -> {
        String s1 = (String) o1;
        String s2 = (String) o2;

        String cleanO1 = s1.replaceAll("[^\\d]", "");
        String cleanO2 = s2.replaceAll("[^\\d]", "");

        if (cleanO1.isEmpty() && cleanO2.isEmpty()) {
            return 0;
        } else if (cleanO1.isEmpty()) {
            return -1;
        } else if (cleanO2.isEmpty()) {
            return 1;
        }

        Long n1 = Long.valueOf(cleanO1);
        Long n2 = Long.valueOf(cleanO2);

        return Long.compare(n1, n2);
    };
    
    private void addSelectDate() {
        dateStart.setDateFormatString("dd/MM/yyyy");
        dateStart.setBackground(Color.white);
        PnldateStart.add(dateStart).setVisible(true);

        dateEnd.setDateFormatString("dd/MM/yyyy");
        dateEnd.setBackground(Color.white);
        PnldateEnd.add(dateEnd).setVisible(true);
    }
    
    public void loc() throws ParseException {
        if (checkDate()) {
            String input = txtnhacungcap.getText();
            if (input == null) {
                input = "";
            }

            Date time_start = dateStart.getDate();
            if (time_start == null) {
                time_start = new Date(0);
            }

            Date time_end = dateEnd.getDate();
            if (time_end == null) {
                time_end = new Date(System.currentTimeMillis());
            }

            this.listnccTH = thongKeBUS.locNhaCungCap(input, new Date(time_start.getTime()), new Date(time_end.getTime()));
            themDuLieuVaoBang(listnccTH);
        }
    }
    
    public boolean checkDate() throws ParseException {
        Date time_start = dateStart.getDate();
        Date time_end = dateEnd.getDate();

        Date current_date = new Date();
        if (time_start != null && time_start.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            dateStart.setCalendar(null);
            return false;
        }
        if (time_end != null && time_end.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            dateEnd.setCalendar(null);
            return false;
        }
        if (time_start != null && time_end != null && time_start.after(time_end)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            dateEnd.setCalendar(null);
            return false;
        }
        return true;
    }
    
    private void themDuLieuVaoBang(ArrayList<ThongKeNccDTO> list) {
        DefaultTableModel model = (DefaultTableModel) tblThongKeNcc.getModel();
        model.setRowCount(0);

        int k = 1;
        for (ThongKeNccDTO i : list) {
            Object[] row
                    = {k,
                        i.getMancc(),
                        i.getTenncc(),
                        i.getSoluong(),
                        formatTien(i.getTongtien())
                    };
            model.addRow(row);
            k++;
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblThongKeNcc.getColumnCount(); i++) {
            tblThongKeNcc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    public String formatTien(double tien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        return decimalFormat.format(tien);
    }
    
    

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCenter = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnhacungcap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PnldateStart = new javax.swing.JPanel();
        PnldateEnd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeNcc = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tìm kiếm nhà cung cấp");

        txtnhacungcap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnhacungcapKeyReleased(evt);
            }
        });

        jLabel2.setText("Từ ngày");

        PnldateStart.setLayout(new javax.swing.BoxLayout(PnldateStart, javax.swing.BoxLayout.LINE_AXIS));

        PnldateEnd.setLayout(new javax.swing.BoxLayout(PnldateEnd, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText("Đến ngày");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(PnldateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtnhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addComponent(PnldateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtnhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnldateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnldateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelCenterLayout = new javax.swing.GroupLayout(PanelCenter);
        PanelCenter.setLayout(PanelCenterLayout);
        PanelCenterLayout.setHorizontalGroup(
            PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCenterLayout.setVerticalGroup(
            PanelCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCenterLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(PanelCenter, java.awt.BorderLayout.WEST);

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyReleased(evt);
            }
        });

        tblThongKeNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhà cung cấp", "Tên nhà cung cấp", "Số lượng nhập", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tblThongKeNcc);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnhacungcapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnhacungcapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnhacungcapKeyReleased

    private void jScrollPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyReleased
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            loc();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            loc();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCenter;
    private javax.swing.JPanel PnldateEnd;
    private javax.swing.JPanel PnldateStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKeNcc;
    private javax.swing.JTextField txtnhacungcap;
    // End of variables declaration//GEN-END:variables


}
