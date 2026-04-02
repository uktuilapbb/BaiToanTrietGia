package controller;

import dao.UserDAO;
import view.LoginView;
import view.MainView;
import model.DBConnection;
import javax.swing.JOptionPane;

public class LoginController {
    private LoginView view;
    private UserDAO dao;
    private DBConnection db;

    public LoginController(LoginView view) {
        this.view = view;
        this.db = new DBConnection();
        this.dao = new UserDAO(db);

        // Lắng nghe sự kiện
        this.view.getBtnLogin().addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String user = view.getTxtUsername().getText();
        String pass = new String(view.getTxtPassword().getPassword());

        if (dao.login(user, pass)) {
            JOptionPane.showMessageDialog(view, "Đăng nhập thành công!");
            view.dispose(); // Đóng cửa sổ login

            // Mở MainView và truyền kết nối DB sang các controller tiếp theo
            MainView mainV = new MainView();
            new MainController(mainV, db);
            mainV.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Sai tài khoản hoặc mật khẩu!");
        }
    }
}