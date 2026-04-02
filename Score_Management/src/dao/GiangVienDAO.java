package dao;

import model.DBConnection;
import model.GiangVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiangVienDAO {
    private DBConnection db;

    public GiangVienDAO(DBConnection db) { this.db = db; }

    // ✅ TÌM THEO TÊN GIẢNG VIÊN (theo giao diện)
    public List<GiangVien> searchByTenGV(String keyword) {
        List<GiangVien> list = new ArrayList<>();
        String sql = "SELECT * FROM GiangVien WHERE TenGV LIKE ? ORDER BY TenGV";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new GiangVien(
                        rs.getString("MaGV"),
                        rs.getString("TenGV"),
                        rs.getString("DiaChi"),
                        rs.getString("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("ChuyenNganh"),
                        rs.getString("SDT")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy tất cả GV
    public List<GiangVien> getAllGiangVien() {
        List<GiangVien> list = new ArrayList<>();
        String sql = "SELECT * FROM GiangVien ORDER BY MaGV";
        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new GiangVien(
                        rs.getString("MaGV"),
                        rs.getString("TenGV"),
                        rs.getString("DiaChi"),
                        rs.getString("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("ChuyenNganh"),
                        rs.getString("SDT")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
