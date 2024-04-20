package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import DTO.ThongKe.ThongKeKhachHangDTO;
import config.MySQLConnection;

public class ThongKeDAO {

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
}
