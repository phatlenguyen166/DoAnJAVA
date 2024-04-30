/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ChiTietPhieuNhapDAO;
import DAO.PhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import GUI.PhieuNhap;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author this pc
 */
public class PhieuNhapBUS {
    PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    ChiTietPhieuNhapDAO chiTietPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
    ArrayList<PhieuNhapDTO> selectedPNproducts;
    public PhieuNhapBUS() {
    }
    
    public ArrayList<PhieuNhapDTO> getAllPhieuNhap(){
        return phieuNhapDAO.getAllPhieuNhap();
    }   

     
    public PhieuNhapDTO selectByID(int mapn){
        return phieuNhapDAO.selectById(mapn);
    }
    
//    public ArrayList<PhieuNhapDTO> getAllPhieuNhap() {
//        return phieuNhapDAO.getAllPhieuNhap();
//    }
    
    public ArrayList<ChiTietPhieuNhapDTO> getListChiTietPhieuNhap(int mapn){
        return chiTietPhieuNhapDAO.getAllChiTietPhieuNhap(mapn);
    }
    
    public boolean DeletePhieuNhap(int mapn){
        return phieuNhapDAO.DeletePhieuNhap(mapn);
    }
    
    //HÀM LỌC PHIẾU NHẬP 
    public ArrayList<PhieuNhapDTO> filterNCC(String tenNCC) {
        ArrayList<PhieuNhapDTO> phieunhapdaloc = new ArrayList<>();
        System.out.println("tên nhà cung cấp:" + tenNCC);

        // Kiểm tra nhaCungCapBUS không null trước khi sử dụng
        if (nhaCungCapBUS != null) {
            this.selectedPNproducts = getAllPhieuNhap();
            for (PhieuNhapDTO checkphieunhap : this.selectedPNproducts) {
                String tenNhaCungCap = (String) nhaCungCapBUS.selectByID(checkphieunhap.getManhacungcap()).getTenncc();
                if (tenNhaCungCap != null && tenNCC.equals(tenNhaCungCap)) {
                    phieunhapdaloc.add(checkphieunhap);
                    System.out.println("Phieu nhap da loc:" + checkphieunhap);
                }
            }
        }
        return phieunhapdaloc;
    }

    
    
    
    
}
