/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.KhuVucKhoDAO;
import DTO.KhuVucKhoDTO;
import java.util.ArrayList;

/**
 *
 * @author phatl
 */
public class KhuVucKhoBUS {
    private final KhuVucKhoDAO khuVucKhoDAO = new KhuVucKhoDAO();
    
    public KhuVucKhoBUS(){
    }
    
    public ArrayList<KhuVucKhoDTO> getAllKho() {         
        return khuVucKhoDAO.gettAllKho();        
    }

    
    public String[] getArrTenKho() {
        int size = getAllKho().size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = getAllKho().get(i).getTenkhuvuc();
        }
        return result;
    } 
    
    
}


