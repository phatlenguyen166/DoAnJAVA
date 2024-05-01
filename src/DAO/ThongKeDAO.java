package DAO;

import DTO.ThongKe.ThongKeDoanhThuDTO; //tk theo nam
import DTO.ThongKe.ThongKeTheoThangDTO; //tk theo thang
import DTO.ThongKe.ThongKeKhachHangDTO;
import DTO.ThongKeSanPhamBanChayDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import config.MySQLConnection;

public class ThongKeDAO {

    public static ThongKeDAO getInstance() {
        return new ThongKeDAO();
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getTop5SanPhamBanChay() {
        Connection con = MySQLConnection.getConnection();
        ArrayList<ThongKeSanPhamBanChayDTO> listThongSP = new ArrayList<>();
        String sql = "SELECT sp.masp, sp.tensp, SUM(ct.soluong) AS soluong_ban "
                + "FROM sanpham sp "
                + "JOIN ctphieuxuat ct ON sp.masp = ct.masp "
                + "GROUP BY sp.tensp "
                + "ORDER BY soluong_ban DESC ";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tensp = rs.getString("tensp");
                int soluongBan = rs.getInt("soluong_ban");

                ThongKeSanPhamBanChayDTO thongKeSanPhamBanChayDTO = new ThongKeSanPhamBanChayDTO(tensp, soluongBan);
                listThongSP.add(thongKeSanPhamBanChayDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
            // Ghi log hoặc xử lý exception theo nhu cầu của bạn
        } finally {
            // Đóng kết nối sau khi sử dụng xong
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý exception khi đóng kết nối
            }
        }
        return listThongSP;
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getListSanPhamBanChay() {
        Connection con = MySQLConnection.getConnection();
        ArrayList<ThongKeSanPhamBanChayDTO> listThongSP = new ArrayList<>();
        String sql = "SELECT sp.masp, sp.tensp, SUM(ct.soluong) AS soluong_ban "
                + "FROM sanpham sp "
                + "JOIN ctphieuxuat ct ON sp.masp = ct.masp "
                + "GROUP BY sp.tensp "
                + "ORDER BY soluong_ban DESC ";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tensp = rs.getString("tensp");
                int soluongBan = rs.getInt("soluong_ban");

                ThongKeSanPhamBanChayDTO thongKeSanPhamBanChayDTO = new ThongKeSanPhamBanChayDTO(tensp, soluongBan);
                listThongSP.add(thongKeSanPhamBanChayDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
            // Ghi log hoặc xử lý exception theo nhu cầu của bạn
        } finally {
            // Đóng kết nối sau khi sử dụng xong
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý exception khi đóng kết nối
            }
        }
        return listThongSP;
    }

    public ArrayList<ThongKeSanPhamBanChayDTO> getListSanPhamBanChay(int thang, int nam) {
        Connection con = MySQLConnection.getConnection();
        ArrayList<ThongKeSanPhamBanChayDTO> listThongSP = new ArrayList<>();
        String sql = "SELECT sp.masp, sp.tensp, SUM(ct.soluong) AS soluong_ban "
                + "FROM sanpham sp "
                + "JOIN ctphieuxuat ct ON sp.masp = ct.masp "
                + "JOIN phieuxuat px ON ct.maphieuxuat = px.maphieuxuat "
                + "WHERE MONTH(px.thoigian) = ? AND YEAR(px.thoigian) = ? "
                + "GROUP BY sp.tensp "
                + "ORDER BY soluong_ban DESC ";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, thang); // Thiết lập tháng
            pst.setInt(2, nam); // Thiết lập năm
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tensp = rs.getString("tensp");
                int soluongBan = rs.getInt("soluong_ban");

                ThongKeSanPhamBanChayDTO thongKeSanPhamBanChayDTO = new ThongKeSanPhamBanChayDTO(tensp, soluongBan);
                listThongSP.add(thongKeSanPhamBanChayDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi
            // Ghi log hoặc xử lý exception theo nhu cầu của bạn
        } finally {
            // Đóng kết nối sau khi sử dụng xong
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Xử lý exception khi đóng kết nối
            }
        }
        return listThongSP;
    }

    public ArrayList<ThongKeKhachHangDTO> getThongKeKhachHang(String text, Date timeStart, Date timeEnd) {
        ArrayList<ThongKeKhachHangDTO> result = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeEnd.getTime());
        // Đặt giá trị cho giờ, phút, giây và mili giây của Calendar
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        try {
            Connection con = MySQLConnection.getConnection();
            String sql = "SELECT khachhang.makh, khachhang.tenkhachhang, COUNT(phieuxuat.maphieuxuat) AS soluong, IFNULL(SUM(phieuxuat.tongtien), 0) AS total "
                    + "FROM khachhang, phieuxuat "
                    + "WHERE khachhang.makh = phieuxuat.makh AND phieuxuat.thoigian BETWEEN ? AND ? "
                    + "GROUP BY khachhang.makh, khachhang.tenkhachhang "
                    + "HAVING ( khachhang.tenkhachhang LIKE ? OR khachhang.makh LIKE ? ) AND soluong > 0";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setTimestamp(1, new Timestamp(timeStart.getTime()));
            pst.setTimestamp(2, new Timestamp(calendar.getTimeInMillis()));
            pst.setString(3, "%" + text + "%");
            pst.setString(4, "%" + text + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int makh = rs.getInt("makh");
                String tenkh = rs.getString("tenkhachhang");
                int soluong = rs.getInt("soluong");
                long tongtien = rs.getInt("total");
                ThongKeKhachHangDTO x = new ThongKeKhachHangDTO(makh, tenkh, soluong, tongtien);
                result.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ThongKeDoanhThuDTO> getDoanhThuTheoTungNam(int year_start, int year_end) {
        ArrayList<ThongKeDoanhThuDTO> result = new ArrayList<>();
        try {
            Connection con = MySQLConnection.getConnection();
            String sqlSetStartYear = "SET @start_year = ?;";
            String sqlSetEndYear = "SET @end_year = ?;";
            String sqlSelect = """
                     WITH RECURSIVE years(year) AS (
                       SELECT @start_year
                       UNION ALL
                       SELECT year + 1
                       FROM years
                       WHERE year < @end_year
                     )
                     SELECT 
                       years.year AS nam,
                       COALESCE(SUM(ctphieunhap.dongia), 0) AS chiphi, 
                       COALESCE(SUM(ctphieuxuat.dongia), 0) AS doanhthu
                     FROM years
                     LEFT JOIN phieuxuat ON YEAR(phieuxuat.thoigian) = years.year
                     LEFT JOIN ctphieuxuat ON phieuxuat.maphieuxuat = ctphieuxuat.maphieuxuat
                     LEFT JOIN sanpham ON sanpham.masp = ctphieuxuat.masp
                     LEFT JOIN ctphieunhap ON sanpham.masp = ctphieunhap.masp
                     GROUP BY years.year
                     ORDER BY years.year;""";
            PreparedStatement pstStartYear = con.prepareStatement(sqlSetStartYear);
            PreparedStatement pstEndYear = con.prepareStatement(sqlSetEndYear);
            PreparedStatement pstSelect = con.prepareStatement(sqlSelect);

            pstStartYear.setInt(1, year_start);
            pstEndYear.setInt(1, year_end);

            pstStartYear.execute();
            pstEndYear.execute();

            ResultSet rs = pstSelect.executeQuery();
            while (rs.next()) {
                int thoigian = rs.getInt("nam");
                Long chiphi = rs.getLong("chiphi");
                Long doanhthu = rs.getLong("doanhthu");
                ThongKeDoanhThuDTO x = new ThongKeDoanhThuDTO(thoigian, chiphi, doanhthu, doanhthu - chiphi);
                result.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<ThongKeTheoThangDTO> getThongKeTheoThang(int nam) {
        ArrayList<ThongKeTheoThangDTO> result = new ArrayList<>();
        try {
            Connection con = MySQLConnection.getConnection();
            String sql = "SELECT months.month AS thang, \n"
                    + "       COALESCE(SUM(ctphieunhap.dongia), 0) AS chiphi,\n"
                    + "       COALESCE(SUM(ctphieuxuat.dongia), 0) AS doanhthu\n"
                    + "FROM (\n"
                    + "       SELECT 1 AS month\n"
                    + "       UNION ALL SELECT 2\n"
                    + "       UNION ALL SELECT 3\n"
                    + "       UNION ALL SELECT 4\n"
                    + "       UNION ALL SELECT 5\n"
                    + "       UNION ALL SELECT 6\n"
                    + "       UNION ALL SELECT 7\n"
                    + "       UNION ALL SELECT 8\n"
                    + "       UNION ALL SELECT 9\n"
                    + "       UNION ALL SELECT 10\n"
                    + "       UNION ALL SELECT 11\n"
                    + "       UNION ALL SELECT 12\n"
                    + "     ) AS months\n"
                    + "LEFT JOIN phieuxuat ON MONTH(phieuxuat.thoigian) = months.month AND YEAR(phieuxuat.thoigian) = ? \n"
                    + "LEFT JOIN ctphieuxuat ON phieuxuat.maphieuxuat = ctphieuxuat.maphieuxuat\n"
                    + "LEFT JOIN sanpham ON sanpham.masp = ctphieuxuat.masp\n"
                    + "LEFT JOIN ctphieunhap ON sanpham.masp = ctphieunhap.masp\n"
                    + "GROUP BY months.month\n"
                    + "ORDER BY months.month;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, nam);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int thang = rs.getInt("thang");
                int chiphi = rs.getInt("chiphi");
                int doanhthu = rs.getInt("doanhthu");
                int loinhuan = doanhthu - chiphi;
                ThongKeTheoThangDTO thongke = new ThongKeTheoThangDTO(thang, chiphi, doanhthu, loinhuan);
                result.add(thongke);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
