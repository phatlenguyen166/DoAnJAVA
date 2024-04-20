/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

/**
 *
 * @author phatl
 */
public class TaiKhoanBUS {

    private final TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    
    public TaiKhoanDTO selectAccountUser(String username){
        return taiKhoanDAO.selectByUser(username);
    }
    
    public String selectTenChucVu(int maquyen){
        return taiKhoanDAO.selectChucVu(maquyen);
    }
}
