package dao;

import model.DBConnection;
import model.Nganh;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NganhDAO {
    private DBConnection db;

    public NganhDAO(DBConnection db) { this.db = db; }

    // Lấy tất cả ngành
    public List<Nganh> getAllNganh() {
        List<Nganh> list = new ArrayList<>();
        String sql = """
            SELECT n.*, k.TenKhoa 
            FROM Nganh n 
            JOIN Khoa k ON n.MaKhoa = k.MaKhoa 
            ORDER BY n.MaNganh
            """;
        try (Statement stmt = db.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Nganh(
                        rs.getString("MaNganh"),
                        rs.getString("TenNganh"),
                        rs.getString("MaKhoa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
