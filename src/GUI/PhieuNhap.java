package GUI;

import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DAO.NhaCungCapDAO;
import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import GUI.Component.BuildTable;
import GUI.Component.ShowCBB;
import GUI.Main;
import GUI.PNhap.ChiTietPhieuNhap;
import GUI.Panel.TaoPhieuNhap;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class PhieuNhap extends javax.swing.JPanel implements ActionListener, PropertyChangeListener, KeyListener, ItemListener {

    PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
    SanPhamBUS sanPhamBUS = new SanPhamBUS();
    PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    TaoPhieuNhap tpn = new TaoPhieuNhap();
    NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap();
    ShowCBB showCBB = new ShowCBB();
    BuildTable buildTable = new BuildTable();
    private NhaCungCapBUS nhaCungCapBUS;
    private DefaultTableModel tblModel;
    private TaoPhieuNhap taoPhieuNhap;
    private PhieuNhap phieuNhap;
    ArrayList<PhieuNhapDTO> selectedPNproducts;
    Main main;

    public PhieuNhap() {
        initComponents();
        addIcon();
        tblPhieuNhap.setFocusable(false);
        tblPhieuNhap.setDefaultEditor(Object.class, null);
        tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblPhieuNhap.setFocusable(false);
        tblPhieuNhap.setAutoCreateRowSorter(true);
        taoPhieuNhap = new TaoPhieuNhap(); // Khởi tạo đối tượng TaoPhieuNhap
        nhaCungCapBUS = new NhaCungCapBUS();

        btnChiTietPN.addActionListener(this);
        comboboxNCC.addItemListener(this);
        datengaybatdau.addPropertyChangeListener(this);
        datengayketthuc.addPropertyChangeListener(this);
        txtminprice.addKeyListener(this);
        txtmaxprice.addKeyListener(this);

        showCBB.CBBNhaCungCap(comboboxNCC);

        // Khởi tạo tblModel
        tblModel = (DefaultTableModel) tblPhieuNhap.getModel();
        this.selectedPNproducts = phieuNhapBUS.getAllPhieuNhap();
        loadDataTalbe(this.selectedPNproducts);

        txtTimKiem.putClientProperty("JTextField.placeholderText", "Tên nhà cung cấp, mã phiếu nhập...");
        txtTimKiem.putClientProperty("JTextField.showClearButton", true);
        txtTimKiem.putClientProperty("JTextField.leadingIcon", new FlatSVGIcon("./icon/search.svg"));
        txtTimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ArrayList<PhieuNhapDTO> rs = phieuNhapBUS.search(txtTimKiem.getText());
                loadDataTalbe(rs);
            }
        });

    }
    TaiKhoanDTO taiKhoanDTO;
    public PhieuNhap(TaiKhoanDTO taiKhoanDTO) {
        initComponents();
        addIcon();
        
        this.taiKhoanDTO = taiKhoanDTO;
        
        tblPhieuNhap.setFocusable(false);
        tblPhieuNhap.setDefaultEditor(Object.class, null);
        tblPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(180);
        tblPhieuNhap.setFocusable(false);
        tblPhieuNhap.setAutoCreateRowSorter(true);
        taoPhieuNhap = new TaoPhieuNhap(); // Khởi tạo đối tượng TaoPhieuNhap
        nhaCungCapBUS = new NhaCungCapBUS();

        btnChiTietPN.addActionListener(this);
        comboboxNCC.addItemListener(this);
        datengaybatdau.addPropertyChangeListener(this);
        datengayketthuc.addPropertyChangeListener(this);
        txtminprice.addKeyListener(this);
        txtmaxprice.addKeyListener(this);

        showCBB.CBBNhaCungCap(comboboxNCC);

        // Khởi tạo tblModel
        tblModel = (DefaultTableModel) tblPhieuNhap.getModel();
        this.selectedPNproducts = phieuNhapBUS.getAllPhieuNhap();
        loadDataTalbe(this.selectedPNproducts);

        txtTimKiem.putClientProperty("JTextField.placeholderText", "Tên nhà cung cấp, mã phiếu nhập...");
        txtTimKiem.putClientProperty("JTextField.showClearButton", true);
        txtTimKiem.putClientProperty("JTextField.leadingIcon", new FlatSVGIcon("./icon/search.svg"));
        txtTimKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ArrayList<PhieuNhapDTO> rs = phieuNhapBUS.search(txtTimKiem.getText());
                loadDataTalbe(rs);
            }
        });

    }

    private void addIcon() {
        btnThemPN.setIcon(new FlatSVGIcon("./icon/add.svg"));
        btnChiTietPN.setIcon(new FlatSVGIcon("./icon/edit.svg"));
        btnHuyPhieu.setIcon(new FlatSVGIcon("./icon/cancel.svg"));
        btnXuatExcelPN.setIcon(new FlatSVGIcon("./icon/export_excel.svg"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        mainContentPN = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        btnThemPN = new javax.swing.JButton();
        btnChiTietPN = new javax.swing.JButton();
        btnHuyPhieu = new javax.swing.JButton();
        btnXuatExcelPN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        pnlBottom = new javax.swing.JPanel();
        scpnlshow = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        pnlLoc = new javax.swing.JPanel();
        txtnhacungcap = new javax.swing.JLabel();
        comboboxNCC = new javax.swing.JComboBox<>();
        txtnhacungcap1 = new javax.swing.JLabel();
        txtnhacungcap2 = new javax.swing.JLabel();
        cbxNhanVien = new javax.swing.JComboBox<>();
        txtnhacungcap3 = new javax.swing.JLabel();
        txtnhacungcap4 = new javax.swing.JLabel();
        txtmaxprice = new javax.swing.JTextField();
        txtnhacungcap5 = new javax.swing.JLabel();
        txtminprice = new javax.swing.JTextField();
        datengaybatdau = new com.toedter.calendar.JDateChooser();
        datengayketthuc = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.BorderLayout());

        mainContentPN.setPreferredSize(new java.awt.Dimension(1300, 800));
        mainContentPN.setLayout(new java.awt.BorderLayout());

        pnlTop.setBackground(new java.awt.Color(255, 255, 255));
        pnlTop.setPreferredSize(new java.awt.Dimension(1200, 70));

        btnThemPN.setText("Thêm");
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnThemPN);

        btnChiTietPN.setText("Chi tiết");
        btnChiTietPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnChiTietPN);

        btnHuyPhieu.setText("Hủy phiếu");
        btnHuyPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhieuActionPerformed(evt);
            }
        });
        pnlTop.add(btnHuyPhieu);

        btnXuatExcelPN.setText("Xuất excel");
        btnXuatExcelPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelPNActionPerformed(evt);
            }
        });
        pnlTop.add(btnXuatExcelPN);

        jLabel1.setText("Tìm kiếm :");
        pnlTop.add(jLabel1);

        txtTimKiem.setPreferredSize(new java.awt.Dimension(300, 30));
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        pnlTop.add(txtTimKiem);

        mainContentPN.add(pnlTop, java.awt.BorderLayout.NORTH);

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu nhập", "Nhà cung cấp", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        scpnlshow.setViewportView(tblPhieuNhap);

        pnlLoc.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoc.setPreferredSize(new java.awt.Dimension(270, 700));

        txtnhacungcap.setText("Nhân viên nhập");

        comboboxNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        comboboxNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxNCCActionPerformed(evt);
            }
        });

        txtnhacungcap1.setText("Đến số tiền (VND)");

        txtnhacungcap2.setText("Từ ngày");

        cbxNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        txtnhacungcap3.setText("Đến ngày");

        txtnhacungcap4.setText("Nhà cung cấp");

        txtnhacungcap5.setText("Từ số tiền (VND)");

        javax.swing.GroupLayout pnlLocLayout = new javax.swing.GroupLayout(pnlLoc);
        pnlLoc.setLayout(pnlLocLayout);
        pnlLocLayout.setHorizontalGroup(
            pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtminprice)
                    .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtmaxprice)
                            .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboboxNCC, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnhacungcap2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnhacungcap1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, 0, 248, Short.MAX_VALUE))
                                .addComponent(txtnhacungcap3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtnhacungcap4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnhacungcap5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datengaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datengayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlLocLayout.setVerticalGroup(
            pnlLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtnhacungcap4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datengaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datengayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtminprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(txtnhacungcap1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmaxprice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpnlshow, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addComponent(scpnlshow))
                .addContainerGap())
        );

        mainContentPN.add(pnlBottom, java.awt.BorderLayout.CENTER);

        add(mainContentPN, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnXuatExcelPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelPNActionPerformed

    private void btnHuyPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhieuActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn hủy phiếu nhập này?", "Xác nhận hủy", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            DeletePhieuNhap();
        }
    }//GEN-LAST:event_btnHuyPhieuActionPerformed

    // Thêm bộ lắng nghe cho combobox
//    public void itemStateChanged(ItemEvent e) {
//        if (e.getStateChange() == ItemEvent.SELECTED) {
//            String selectedNcc = (String) comboboxNCC.getSelectedItem();
//            if (!selectedNcc.equals("Tất cả")) {
//                loadDataTalbe(phieuNhapBUS.filterNCC(selectedNcc)); // Lọc dữ liệu theo nhà cung cấp đã chọn
//            } else {
//                loadDataTalbe(phieuNhapBUS.getAllPhieuNhap()); // Hiển thị lại toàn bộ dữ liệu nếu chọn "Tất cả"
//            }
//        }
//    }
    //HÀM HỦY PHIẾU NHẬP
    public void DeletePhieuNhap() {
        taoPhieuNhap = new TaoPhieuNhap();

        int selectedRow = tblPhieuNhap.getSelectedRow();

        if (selectedRow != -1) {
            phieuNhapBUS = new PhieuNhapBUS(); // tạo mới cho thanhcong trong lệnh if này, nếu chỉ tạo 1 cái thì điều kiện xóa sẽ lỗi kết nối sql
            int maspColumnIndex = taoPhieuNhap.getColumnIndexByName("Mã phiếu nhập", tblPhieuNhap);
            int mapn = (int) tblPhieuNhap.getValueAt(selectedRow, maspColumnIndex);
            boolean thanhcong = phieuNhapBUS.DeletePhieuNhap(mapn);
            if (thanhcong) {
                phieuNhapBUS = new PhieuNhapBUS();
                JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công");
                selectedPNproducts = phieuNhapBUS.getAllPhieuNhap();
                loadDataTalbe(selectedPNproducts);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa sản phẩm lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phảm để xóa");
        }
    }

    private void btnChiTietPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPNActionPerformed
        chiTietPhieuNhap = new ChiTietPhieuNhap();

    }//GEN-LAST:event_btnChiTietPNActionPerformed


    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed
        // Ẩn các thành phần hiện tại
        pnlBottom.setVisible(false);
        pnlLoc.setVisible(false);
        pnlTop.setVisible(false);
        // Tạo một thể hiện của panel từ file java khác
        TaoPhieuNhap taoPhieuNhap = new TaoPhieuNhap(taiKhoanDTO);
        // Thêm taoPhieuNhap vào mainContentPN
        mainContentPN.add(taoPhieuNhap);
        mainContentPN.revalidate();
        mainContentPN.repaint();

    }//GEN-LAST:event_btnThemPNActionPerformed

    private void comboboxNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxNCCActionPerformed
    }//GEN-LAST:event_comboboxNCCActionPerformed

//Hàm hiển thị mảng phiếu nhập
    private void HienThiListPhieuNhap(ArrayList<PhieuNhapDTO> listPhieuNhap) {
        DefaultTableModel model = (DefaultTableModel) tblPhieuNhap.getModel();
        model.setRowCount(0);
        for (PhieuNhapDTO pn : listPhieuNhap) {
            Object[] row = {
                pn.getManhacungcap(),
                pn.getMaphieunhap(),
                pn.getMaNV(),
                pn.getThoigiantao(),
                pn.getTongTien()
            };
            model.addRow(row);
        }

        // Tạo renderer để hiển thị nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int i = 0; i < tblPhieuNhap.getColumnCount(); i++) { // Sửa tblSanPham thành tblPhieuNhap
            tblPhieuNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void loadDataTalbe(ArrayList<PhieuNhapDTO> listphieunhap) {
        tblModel.setRowCount(0); // Xóa tất cả các hàng trong bảng
        int i = 1;
        for (PhieuNhapDTO pn : listphieunhap) {
            String TenNcc = nhaCungCapDAO.selectById(pn.getManhacungcap()).getTenncc();
            DecimalFormat decimalFormat = new DecimalFormat("#,### đ"); // Khởi tạo một đối tượng DecimalFormat
            Object[] rowData = {
                i++,
                pn.getMaphieunhap(),
                TenNcc,
                pn.getMaNV(),
                pn.getThoigiantao(),
                decimalFormat.format(pn.getTongTien())
            };
            tblModel.addRow(rowData); // Thêm hàng mới vào bảng
        }
        // Tạo renderer để căn giữa nội dung ở giữa ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Áp dụng renderer cho từng cột trong bảng
        for (int j = 0; j < tblModel.getColumnCount(); j++) {
            tblPhieuNhap.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
    }

    private PhieuNhapDTO selectPhieuNhap() {
        int selectedRow = tblPhieuNhap.getSelectedRow();
        PhieuNhapDTO result = null;
        if (selectedRow != -1) {
            //int mapnColumnIndex = taoPhieuNhap.getColumnIndexByName("Mã xuất phiếu", tblPhieuNhap); // Sử dụng đối tượng taoPhieuNhap để gọi phương thức getColumnIndexByName
            int mapn = (int) tblPhieuNhap.getValueAt(selectedRow, 1);
            phieuNhapBUS = new PhieuNhapBUS();
            result = phieuNhapBUS.selectByID(mapn);
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChiTietPN) {
            if (selectPhieuNhap() != null) {
                chiTietPhieuNhap = new ChiTietPhieuNhap(selectPhieuNhap());
                chiTietPhieuNhap.setLocationRelativeTo(null);
                chiTietPhieuNhap.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboboxNCC) {
            Fillter();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == datengaybatdau && "date".equals(evt.getPropertyName())) {
            Fillter();
        } else if ("date".equals(evt.getPropertyName()) && evt.getSource() == datengayketthuc) {
            Fillter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtmaxprice || e.getSource() == txtminprice) {
            Fillter();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void Fillter() {
        if (validateSelectDate()) {
            ArrayList<PhieuNhapDTO> listphieu = new ArrayList<>();
            //int type = search.cbxChoose.getSelectedIndex();
            String selectedNcc = (String) comboboxNCC.getSelectedItem();
            int mancc = comboboxNCC.getSelectedIndex() == 0 ? 0 : phieuNhapBUS.getMancc(selectedNcc);
//            int manv = cbxNhanVien.getSelectedIndex() == 0 ? 0 : nvBUS.getByIndex(cbxNhanVien.getSelectedIndex() - 1).getManv();
            int manv = 1;
            //String input = search.txtSearchForm.getText() != null ? search.txtSearchForm.getText() : "";
            Date time_start = datengaybatdau.getDate() != null ? datengaybatdau.getDate() : new Date(0);
            Date time_end = datengayketthuc.getDate() != null ? datengayketthuc.getDate() : new Date(System.currentTimeMillis());
            String min_price = String.valueOf(txtminprice.getText());
            String max_price = txtmaxprice.getText();
            listphieu = phieuNhapBUS.fillerPhieuNhap(mancc, manv, time_start, time_end, min_price, max_price);
            loadDataTalbe(listphieu);
        }
    }

    public boolean validateSelectDate() {
        Date time_start = datengaybatdau.getDate();
        Date time_end = datengayketthuc.getDate();

        Date current_date = new Date();
        if (time_start != null && time_start.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            datengaybatdau.setCalendar(null);
            return false;
        }
        if (time_end != null && time_end.after(current_date)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được lớn hơn ngày hiện tại", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            datengayketthuc.setCalendar(null);
            return false;
        }
        if (time_start != null && time_end != null && time_start.after(time_end)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu", "Lỗi !", JOptionPane.ERROR_MESSAGE);
            datengayketthuc.setCalendar(null);
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietPN;
    private javax.swing.JButton btnHuyPhieu;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnXuatExcelPN;
    private javax.swing.JComboBox<String> cbxNhanVien;
    public javax.swing.JComboBox<String> comboboxNCC;
    public com.toedter.calendar.JDateChooser datengaybatdau;
    public com.toedter.calendar.JDateChooser datengayketthuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainContentPN;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlLoc;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JScrollPane scpnlshow;
    public javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtTimKiem;
    public javax.swing.JTextField txtmaxprice;
    public javax.swing.JTextField txtminprice;
    private javax.swing.JLabel txtnhacungcap;
    private javax.swing.JLabel txtnhacungcap1;
    private javax.swing.JLabel txtnhacungcap2;
    private javax.swing.JLabel txtnhacungcap3;
    private javax.swing.JLabel txtnhacungcap4;
    private javax.swing.JLabel txtnhacungcap5;
    // End of variables declaration//GEN-END:variables

}
