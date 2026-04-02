package model;

import java.sql.*;

public class DBConnection {
    // ⚠️ ĐẢM BẢO TÊN DATABASE LÀ 'students_db' VÀ PASS LÀ '123456'
    private static final String URL = "jdbc:mysql://localhost:3306/students_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private Connection connection;

    public DBConnection() {
        connect();
    }

    private void connect() {
        try {
            // 1. Kiểm tra Driver (com.mysql.cj.jdbc.Driver cho bản 8.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Thiết lập kết nối
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✅ [Database] Kết nối MySQL thành công!");

        } catch (ClassNotFoundException e) {
            System.err.println("❌ [Lỗi] Thiếu thư viện MySQL Driver (JAR)!");
            System.err.println("👉 Cách fix: Ctrl + Alt + Shift + S -> Libraries -> Add file .jar của bạn vào.");
        } catch (SQLException e) {
            System.err.println("❌ [Lỗi SQL] Không thể kết nối đến Database!");
            System.err.println("👉 Kiểm tra: 1. XAMPP/MySQL đã bật? 2. Đã tạo DB 'students_db' chưa? 3. Pass đúng '123456'?");
            e.printStackTrace();
        }
    }

    // Getter để các lớp DAO (SinhVienDAO, UserDAO...) gọi
    public Connection getConnection() {
        try {
            // Nếu connection bị đóng hoặc null thì kết nối lại
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Đóng kết nối
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 [Database] Đã đóng kết nối.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}