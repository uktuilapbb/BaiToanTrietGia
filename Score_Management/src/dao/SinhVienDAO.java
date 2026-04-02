package dao;

import model.DBConnection;
import model.SinhVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private DBConnection db;

    public SinhVienDAO(DBConnection db) {
        this.db = db;
    }

    // ================== LẤY TẤT CẢ SINH VIÊN ==================
    public List<SinhVien> getAllSinhVien() {
        List<SinhVien> list = new ArrayList<>();
        String sql =
                "SELECT * FROM SinhVien ORDER BY MaSV";

        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("MaSV"),
                        rs.getString("TenSV"),
                        rs.getString("DiaChi"),
                        rs.getString("GioiTinh"),
                        rs.getDate("NgaySinh"), // sql.Date OK
                        rs.getString("MaLop")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================== TÌM THEO TÊN / MÃ ==================
    public List<SinhVien> searchByTenSV(String keyword) {
        List<SinhVien> list = new ArrayList<>();
        String sql =
                "SELECT * FROM SinhVien " +
                        "WHERE TenSV LIKE ? OR MaSV LIKE ? " +
                        "ORDER BY MaSV";

        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("MaSV"),
                        rs.getString("TenSV"),
                        rs.getString("DiaChi"),
                        rs.getString("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("MaLop")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================== LẤY SV THEO MÃ ==================
    public SinhVien getSinhVienByMaSV(String maSV) {
        String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";

        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new SinhVien(
                        rs.getString("MaSV"),
                        rs.getString("TenSV"),
                        rs.getString("DiaChi"),
                        rs.getString("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("MaLop")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ================== THÊM SINH VIÊN ==================
    public boolean addSinhVien(SinhVien sv) {
        String sql = "INSERT INTO SinhVien VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {

            pstmt.setString(1, sv.getMaSV());
            pstmt.setString(2, sv.getTenSV());
            pstmt.setString(3, sv.getDiaChi());
            pstmt.setString(4, sv.getGioiTinh());

            // 🔴 FIX setDate
            java.sql.Date sqlDate =
                    new java.sql.Date(sv.getNgaySinh().getTime());
            pstmt.setDate(5, sqlDate);

            pstmt.setString(6, sv.getMaLop());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================== CẬP NHẬT SINH VIÊN ==================
    public boolean updateSinhVien(SinhVien sv) {
        String sql =
                "UPDATE SinhVien SET TenSV=?, DiaChi=?, GioiTinh=?, NgaySinh=?, MaLop=? " +
                        "WHERE MaSV=?";

        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {

            pstmt.setString(1, sv.getTenSV());
            pstmt.setString(2, sv.getDiaChi());
            pstmt.setString(3, sv.getGioiTinh());

            // 🔴 FIX setDate
            java.sql.Date sqlDate =
                    new java.sql.Date(sv.getNgaySinh().getTime());
            pstmt.setDate(4, sqlDate);

            pstmt.setString(5, sv.getMaLop());
            pstmt.setString(6, sv.getMaSV());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================== XÓA SINH VIÊN ==================
    public boolean deleteSinhVien(String maSV) {
        String sql = "DELETE FROM SinhVien WHERE MaSV = ?";

        try (PreparedStatement pstmt = db.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, maSV);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
