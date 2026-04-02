package view;

import dao.LeaveRequestDAO;
import model.LeaveRequest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OwnerLeaveRequestView extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private LeaveRequestDAO dao = new LeaveRequestDAO();

    public OwnerLeaveRequestView() {
        setTitle("Quản lý đơn xin phép vắng");
        setSize(900, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== HEADER =====
        JLabel title = new JLabel("DANH SÁCH ĐƠN XIN PHÉP", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(33, 150, 243));
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(title, BorderLayout.NORTH);

        // ===== TABLE =====
        model = new DefaultTableModel(
                new String[]{"ID", "Nhân viên", "Ngày xin phép", "Lý do", "Trạng thái"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // không cho sửa trực tiếp
            }
        };

        table = new JTable(model);
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(187, 222, 251));
        loadData();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ===== BUTTON PANEL =====
        JButton btnApprove = new JButton("✔ Duyệt đơn");
        btnApprove.setBackground(new Color(76, 175, 80));
        btnApprove.setForeground(Color.WHITE);
        btnApprove.setFocusPainted(false);
        btnApprove.setFont(new Font("Arial", Font.BOLD, 14));

        btnApprove.addActionListener(e -> approveSelected());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        bottomPanel.add(btnApprove);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Load toàn bộ đơn xin phép
    private void loadData() {
        model.setRowCount(0);
        for (LeaveRequest lr : dao.getAll()) {
            model.addRow(new Object[]{
                    lr.getId(),
                    lr.getFullName(),
                    lr.getLeaveDate(),
                    lr.getReason(),
                    lr.getStatus()
            });
        }
    }

    // Duyệt đơn được chọn
    private void approveSelected() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Vui lòng chọn một đơn để duyệt!");
            return;
        }

        String status = model.getValueAt(row, 4).toString();
        if (!status.equalsIgnoreCase("PENDING")) {
            JOptionPane.showMessageDialog(this,
                    "Đơn này đã được duyệt hoặc từ chối rồi!");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        dao.updateStatus(id, "APPROVED");
        loadData();

        JOptionPane.showMessageDialog(this,
                "✔ Đã duyệt đơn xin phép thành công!");
    }
}
