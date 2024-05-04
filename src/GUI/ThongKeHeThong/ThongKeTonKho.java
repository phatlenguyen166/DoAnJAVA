package GUI.ThongKeHeThong;

import BUS.ThongKeBUS;
import DTO.ThongKeTonKhoDTO;
import GUI.Component.Formater;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author this pc
 */
public class ThongKeTonKho extends javax.swing.JPanel implements ActionListener, KeyListener, PropertyChangeListener{
    ThongKeBUS thongKeBUS = new ThongKeBUS();
    ArrayList<ThongKeTonKhoDTO> listTonKho; 
    Formater formater = new Formater();
    
    public ThongKeTonKho() {
        initComponents();
        listTonKho = thongKeBUS.getThongKeTonKho();
        txttimkiem.putClientProperty("JTextField.showClearButton", true);
        txttimkiem.addKeyListener(this);
        datefrom.addPropertyChangeListener(this);
        dateto.addPropertyChangeListener(this);
        loadDataTable(listTonKho);
    }
    
    private void loadDataTable(ArrayList<ThongKeTonKhoDTO> list) {
        DefaultTableModel tableModel = (DefaultTableModel) tblkho.getModel();
        tableModel.setRowCount(0); // Xóa tất cả các dòng trong bảng trước khi tải dữ liệu mới
    int i = 1;
    for (ThongKeTonKhoDTO dto : list) {
       
        Object[] rowData = new Object[]{
            i++,
            dto.getMasp(), 
            dto.getTensanpham(), 
            dto.getSize(),
            dto.getNhaptrongky(),
            dto.getXuattrongky(), 
            dto.getToncuoiky(),
        };
        tableModel.addRow(rowData); // Thêm dòng dữ liệu vào bảng
    }
    formater.setColumnAlignment(tblkho);
}

    public void filter() throws ParseException{
        if (checkDate()) {
            String input = txttimkiem.getText();
            if (input == null) {
                input = "";
            }

            Date time_start = datefrom.getDate();
            if (time_start == null) {
                time_start = new Date(0);
            }

            Date time_end = dateto.getDate();
            if (time_end == null) {
                time_end = new Date(System.currentTimeMillis());
            }

            this.listTonKho = thongKeBUS.filterTonKho(input, new Date(time_start.getTime()), new Date(time_end.getTime()));
            loadDataTable(listTonKho);
        }
    }

    public boolean checkDate() throws ParseException{
        Date time_start = datefrom.getDate();
        Date time_end = dateto.getDate();

        Date current_date = new Date();
        if (time_start != null && time_start.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            datefrom.setCalendar(null);
            return false;
        }
        if (time_end != null && time_end.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            dateto.setCalendar(null);
            return false;
        }
        if (time_start != null && time_end != null && time_start.after(time_end)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            dateto.setCalendar(null);
            return false;
        }
        return true;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkho = new javax.swing.JTable();
        pnlleft = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        datefrom = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dateto = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        tblkho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên sản phẩm", "Size", "Số lượng nhập", "Số lượng xuất", "Tồn cuối kỳ"
            }
        ));
        jScrollPane1.setViewportView(tblkho);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlleft.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tìm kiếm sản phẩm");

        jLabel2.setText("Từ ngày");

        jLabel3.setText("Đến ngày");

        jButton1.setText("Làm mới");

        jButton2.setText("Xuất Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlleftLayout = new javax.swing.GroupLayout(pnlleft);
        pnlleft.setLayout(pnlleftLayout);
        pnlleftLayout.setHorizontalGroup(
            pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlleftLayout.createSequentialGroup()
                .addGroup(pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlleftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datefrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttimkiem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlleftLayout.createSequentialGroup()
                                .addGroup(pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlleftLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addContainerGap())
        );
        pnlleftLayout.setVerticalGroup(
            pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlleftLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(569, Short.MAX_VALUE))
        );

        jPanel1.add(pnlleft, java.awt.BorderLayout.WEST);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            filter();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        try {
            filter();
        } catch (ParseException ex) {
            Logger.getLogger(ThongKeTonKho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser datefrom;
    private com.toedter.calendar.JDateChooser dateto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlleft;
    private javax.swing.JTable tblkho;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
