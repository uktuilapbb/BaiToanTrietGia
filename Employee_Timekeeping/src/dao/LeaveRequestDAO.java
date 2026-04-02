package dao;


import util.DBConnection;
import model.LeaveRequest;
import java.sql.*;
import java.util.*;


public class LeaveRequestDAO {
    public List<LeaveRequest> getAll() {
        List<LeaveRequest> list = new ArrayList<>();
        String sql = "SELECT lr.id, u.full_name, lr.leave_date, lr.reason, lr.status " +
                "FROM LeaveRequest lr JOIN Users u ON lr.user_id=u.id";


        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                LeaveRequest lr = new LeaveRequest();
                lr.setId(rs.getInt("id"));
                lr.setFullName(rs.getString("full_name"));
                lr.setLeaveDate(rs.getString("leave_date"));
                lr.setReason(rs.getString("reason"));
                lr.setStatus(rs.getString("status"));
                list.add(lr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public void updateStatus(int id, String status) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement("UPDATE LeaveRequest SET status=? WHERE id=?")) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}