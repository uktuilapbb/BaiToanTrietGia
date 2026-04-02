package view;

import javax.swing.*;
import java.awt.*;

public class ReportView extends JFrame {
    private JComboBox<String> cboLop;
    private JButton btnThongKe;
    private JLabel lblResult;

    public ReportView() {
        setTitle("Báo Cáo Thống Kê");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Tiêu đề
        JLabel lblHeader = new JLabel("THỐNG KÊ SINH VIÊN THEO LỚP", JLabel.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblHeader, BorderLayout.NORTH);

        // Panel chọn lớp
        JPanel pnlCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        pnlCenter.add(new JLabel("Chọn lớp:"), gbc);

        gbc.gridx = 1;
        cboLop = new JComboBox<>(); // Dữ liệu sẽ được Controller đổ vào
        cboLop.setPreferredSize(new Dimension(150, 25));
        pnlCenter.add(cboLop, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        btnThongKe = new JButton("Xem số lượng");
        pnlCenter.add(btnThongKe, gbc);

        add(pnlCenter, BorderLayout.CENTER);

        // Panel hiển thị kết quả
        lblResult = new JLabel("Số lượng sinh viên: --", JLabel.CENTER);
        lblResult.setFont(new Font("Arial", Font.ITALIC, 14));
        lblResult.setForeground(Color.BLUE);
        add(lblResult, BorderLayout.SOUTH);
    }

    // Getters cho Controller
    public JComboBox<String> getCboLop() { return cboLop; }
    public JButton getBtnThongKe() { return btnThongKe; }
    public JLabel getLblResult() { return lblResult; }
}