/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;

/**
 *
 * @author phatl
 */
public class NhanVienBUS {

    private final NhanVienDAO nhanVienDAO = new NhanVienDAO();
    
    public NhanVienDTO selectThongTinNhanVienByMaNV(int maNV){
        return nhanVienDAO.selectNhanVienByMaNV(maNV);
    }
    
    
}
