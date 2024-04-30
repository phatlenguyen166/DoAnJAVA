/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.ChiTietPhieuXuatDAO;
import DAO.PhieuXuatDAO;
import DTO.ChiTietPhieuXuatDTO;
import DTO.PhieuXuatDTO;
import DTO.SanPhamDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author this pc
 */
public class PhieuXuatBUS {
    PhieuXuatDAO phieuXuatDAO = new PhieuXuatDAO();
    ChiTietPhieuXuatDAO chiTietPhieuXuatDAO = new ChiTietPhieuXuatDAO();
    
    public PhieuXuatBUS() {
    }
    
    public ArrayList<PhieuXuatDTO> getAllPhieuXuat(){
        return phieuXuatDAO.getAllPhieuXuat();
    }   

     
    public PhieuXuatDTO selectByID(int mapn){
        return phieuXuatDAO.selectById(mapn);
    }
    
    public ArrayList<ChiTietPhieuXuatDTO> getAllChiTietPhieuXuat(int mapn){
        return chiTietPhieuXuatDAO.getAllChiTietPhieuXuat(mapn);
    }
    
    public boolean DeletePhieuXuat(int mapx){
        return phieuXuatDAO.DeletePhieuXuat(mapx);
    }
}
