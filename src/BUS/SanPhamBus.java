/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
        


/**
 *
 * @author ADMIN
 */
public class SanPhamBUS {
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    public SanPhamBUS() {
    }
    
    public ArrayList<SanPhamDTO> getAllSanPham(){
        return sanPhamDAO.getAllSanPham();
    }
    
    public boolean themSanPham(SanPhamDTO sanPhamDTO){
        return sanPhamDAO.themSanPham(sanPhamDTO);
    }
    public boolean xoaSanPham(int masp){
        return sanPhamDAO.xoaSanPham(masp);
    }
    
    public boolean suaSanPham(SanPhamDTO sanPhamDTO){
        return sanPhamDAO.suaSanPham(sanPhamDTO);
    }
    public String selectAnhByMaSP(int masp){
        return sanPhamDAO.selectHinhAnhByMaSP(masp);
    }
    
    public SanPhamDTO selectByID(int masp){
        return sanPhamDAO.selectById(masp);
    }
    private ArrayList<SanPhamDTO> listSP = new ArrayList<>();
    public Boolean add(SanPhamDTO lh) {
        boolean check = sanPhamDAO.themSanPham(lh);
        if (check) {

            this.listSP.add(lh);
        }
        return check;
    }
}
