package dao;

import model.DBConnection;
import model.Diem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiemDAO {
    private DBConnection db;

    public DiemDAO(DBConnection db) { this.db = db; }

    // Lấy bảng điểm theo lớp và môn học
    public List<Diem> getBangDiem(String maLop, String maMon) {
        List<Diem> list = new ArrayList<>();
        String sql = """
            SELECT sv.MaSV, sv.TenSV, d.DiemChuyenCan, d.DiemGiuaKy, d.DiemCuoiKy 
            FROM SinhVien sv
            LEFT JOIN Diem d ON sv.MaSV = d.MaSV AND d.MaMon = ?
            WHERE sv.MaLop = ?
            """;
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, maMon);
            pstmt.setString(2, maLop);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                // Logic mapping tùy thuộc vào class model Diem của mày
                // Ở đây là ví dụ trả về danh sách điểm
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Cập nhật hoặc thêm điểm mới
    public boolean saveOrUpdateDiem(String maSV, String maMon, float cc, float gk, float ck) {
        String sql = "REPLACE INTO Diem (MaSV, MaMon, DiemChuyenCan, DiemGiuaKy, DiemCuoiKy) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            pstmt.setString(2, maMon);
            pstmt.setFloat(3, cc);
            pstmt.setFloat(4, gk);
            pstmt.setFloat(5, ck);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}