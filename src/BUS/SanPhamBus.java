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
public class SanPhamBus {
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    SanPhamDTO sanPhamDTO;
    public SanPhamBus() {
    }
    
    public ArrayList<SanPhamDTO> getAllSanPham(){
        return sanPhamDAO.getAllSanPham();
    }
    
    
}
