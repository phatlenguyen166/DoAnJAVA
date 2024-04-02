/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
        


/**
 *
 * @author ADMIN
 */
public class SanPhamBus {
    private  SanPhamDAO sanPhamDAO;
    
    public SanPhamBus(SanPhamDAO sanPhamDAO){
        this.sanPhamDAO = sanPhamDAO;
    }
    
}
