package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    // Để public để Controller truy cập trực tiếp hoặc dùng Getter
    public JTextField txtUsername;
    public JPasswordField txtPassword;
    public JButton btnLogin;

    public LoginView() {
        setTitle("Đăng Nhập Hệ Thống");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Giao diện
        add(new JLabel("  Tên đăng nhập:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("  Mật khẩu:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        add(new JLabel("")); // Khoảng trống
        btnLogin = new JButton("Đăng Nhập");
        add(btnLogin);
    }

    // Các hàm Getter để Controller hết lỗi đỏ
    public JButton getBtnLogin() { return btnLogin; }
    public JTextField getTxtUsername() { return txtUsername; }
    public JPasswordField getTxtPassword() { return txtPassword; }
}