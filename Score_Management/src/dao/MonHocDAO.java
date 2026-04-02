package dao;

import model.DBConnection;
import model.MonHoc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {
    private DBConnection db;

    public MonHocDAO(DBConnection db) { this.db = db; }

    public List<MonHoc> getAllMonHoc() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM MonHoc ORDER BY MaMon";
        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new MonHoc(
                        rs.getString("MaMon"),
                        rs.getString("TenMon"),
                        rs.getInt("SoTinChi")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Tìm theo tên môn (giao diện)
    public List<MonHoc> searchByTenMon(String keyword) {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM MonHoc WHERE TenMon LIKE ?";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MonHoc(
                        rs.getString("MaMon"),
                        rs.getString("TenMon"),
                        rs.getInt("SoTinChi")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
