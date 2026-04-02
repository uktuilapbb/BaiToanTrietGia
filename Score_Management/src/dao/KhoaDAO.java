package dao;

import model.DBConnection;
import model.Khoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {
    private DBConnection db;

    public KhoaDAO(DBConnection db) { this.db = db; }

    // Lấy tất cả khoa
    public List<Khoa> getAllKhoa() {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT * FROM Khoa";
        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Khoa(
                        rs.getString("MaKhoa"),
                        rs.getString("TenKhoa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm khoa
    public boolean addKhoa(Khoa khoa) {
        String sql = "INSERT INTO Khoa VALUES (?, ?)";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, khoa.getMaKhoa());
            pstmt.setString(2, khoa.getTenKhoa());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
