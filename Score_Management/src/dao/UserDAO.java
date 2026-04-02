package dao;

import model.DBConnection;
import model.User;
import java.sql.*;

public class UserDAO {
    private DBConnection db;

    public UserDAO(DBConnection db) {
        this.db = db;
    }

    // ✅ ĐĂNG NHẬP - Theo yêu cầu (admin1/admin2 - 123456)
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // true nếu tìm thấy
        } catch (SQLException e) {
            System.err.println("Lỗi UserDAO.login: " + e.getMessage());
            return false;
        }
    }
}
