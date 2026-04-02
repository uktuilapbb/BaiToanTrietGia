package dao;


import util.DBConnection;
import model.Attendance;
import java.sql.*;
import java.util.*;


public class AttendanceDAO {
    public List<Attendance> getToday() {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT u.full_name, a.check_in, a.check_out, " +
                "CASE WHEN a.check_out IS NULL THEN 'ĐANG LÀM' ELSE 'KHÔNG LÀM' END status " +
                "FROM Attendance a JOIN Users u ON a.user_id=u.id WHERE a.work_date=CURDATE()";


        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                Attendance a = new Attendance();
                a.setFullName(rs.getString("full_name"));
                a.setCheckIn(rs.getString("check_in"));
                a.setCheckOut(rs.getString("check_out"));
                a.setStatus(rs.getString("status"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}