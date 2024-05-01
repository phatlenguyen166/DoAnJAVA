package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKe.ThongKeDoanhThuDTO;
import DTO.ThongKe.ThongKeKhachHangDTO;
//import DTO.ThongKe.ThongKeNhaCungCapDTO;
import DTO.ThongKe.ThongKeTheoThangDTO;
import DTO.ThongKeSanPhamBanChayDTO;
import GUI.ThongKeHeThong.ThongKeSanPhamBanChay;
//import DTO.ThongKe.ThongKeTonKhoDTO;
//import DTO.ThongKe.ThongKeTungNgayTrongThangDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author
 */
public class ThongKeBUS {

    ThongKeDAO thongkeDAO = new ThongKeDAO();

    public ArrayList<ThongKeKhachHangDTO> getAllKhachHang() {
        return thongkeDAO.getThongKeKhachHang("", new Date(0), new Date(System.currentTimeMillis()));
    }

    public ArrayList<ThongKeKhachHangDTO> locKhachHang(String text, Date start, Date end) {
        return thongkeDAO.getThongKeKhachHang(text, start, end);
    }

    public ArrayList<ThongKeDoanhThuDTO> getDoanhThuTheoTungNam(int year_start, int year_end) {
        return this.thongkeDAO.getDoanhThuTheoTungNam(year_start, year_end);
    }

    public ArrayList<ThongKeTheoThangDTO> getThongKeTheoThang(int nam) {
        return thongkeDAO.getThongKeTheoThang(nam);
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getThongKeSanPhamBanChay() {
        return thongkeDAO.getListSanPhamBanChay();
    }
    
    public ArrayList<ThongKeSanPhamBanChayDTO> getThongKeSanPhamBanChay(int thang,int nam) {
        return thongkeDAO.getListSanPhamBanChay(thang,nam);
    }
    public ArrayList<ThongKeSanPhamBanChayDTO> getTop5SanPhamBanChay() {
        return thongkeDAO.getTop5SanPhamBanChay();
    }
}
