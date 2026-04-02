package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public JButton btnSearch, btnReport, btnLogout;

    public MainView() {
        setTitle("Hệ Thống Quản Lý Điểm");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JLabel lblTitle = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        // Menu bên trái hoặc giữa
        JPanel panelMenu = new JPanel(new GridLayout(4, 1, 10, 10));
        btnSearch = new JButton("Tìm Kiếm Sinh Viên/GV");
        btnReport = new JButton("Thống Kê Báo Cáo");
        btnLogout = new JButton("Đăng Xuất");

        panelMenu.add(btnSearch);
        panelMenu.add(btnReport);
        panelMenu.add(btnLogout);

        add(panelMenu, BorderLayout.CENTER);
    }

    // Getters cho Controller
    public JButton getBtnSearch() { return btnSearch; }
    public JButton getBtnReport() { return btnReport; }
}