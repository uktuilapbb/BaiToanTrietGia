package dao;

import model.DBConnection;
import model.Lop;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopDAO {
    private DBConnection db;

    public LopDAO(DBConnection db) { this.db = db; }

    // Lấy tất cả lớp
    public List<Lop> getAllLop() {
        List<Lop> list = new ArrayList<>();
        String sql = """
            SELECT l.*, n.TenNganh 
            FROM Lop l 
            JOIN Nganh n ON l.MaNganh = n.MaNganh 
            ORDER BY l.MaLop
            """;
        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Lop(
                        rs.getString("MaLop"),
                        rs.getString("TenLop"),
                        rs.getString("MaNganh")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy số SV theo lớp
    public int getSoSVDaLop(String maLop) {
        String sql = "SELECT COUNT(*) FROM SinhVien WHERE MaLop = ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, maLop);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
