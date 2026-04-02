import controller.LoginController;
import view.LoginView;
import javax.swing.UIManager;

public class RUN {
    public static void main(String[] args) {
        // 1. Giao diện đẹp hơn một chút (tùy chọn)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Khởi chạy luồng giao diện
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Khởi tạo View (Giao diện đăng nhập)
                LoginView loginView = new LoginView();

                // Khởi tạo Controller để xử lý logic cho View đó
                // Controller này sẽ tự tạo DBConnection và UserDAO bên trong
                new LoginController(loginView);

                // Hiển thị cửa sổ
                loginView.setVisible(true);
            }
        });
    }
}