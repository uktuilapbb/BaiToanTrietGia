package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Cấu hình Database
    // "QuanLiSV" là tên database ông đã tạo trong MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLiSV?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // Sửa user thành "root" (tài khoản mặc định)
    private static final String USER = "root";

    // Mật khẩu:
    // - Trường hợp 1: Để trống "" (thường dùng cho XAMPP)
    // - Trường hợp 2: Nếu không được thì sửa thành "123456"
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Nạp Driver (Cho chắc chắn)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Mở kết nối
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy Driver! Ông kiểm tra lại file .jar chưa?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Lỗi: Không thể kết nối Database!");
            System.err.println("=> Kiểm tra lại Mật khẩu của user 'root'.");
            System.err.println("Chi tiết lỗi: " + e.getMessage());
        }
        return conn;
    }
}