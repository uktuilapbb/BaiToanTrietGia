package view;

import model.SinhVien;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchView extends JFrame {
    public JTextField txtKeyword;
    public JComboBox<String> cboType;
    public JButton btnSearch;
    public JTable tableResult;
    public DefaultTableModel tableModel;

    public SearchView() {
        setTitle("Tìm Kiếm Thông Tin");
        setSize(700, 500);
        setLayout(new BorderLayout());

        // Panel nhập liệu
        JPanel pnlTop = new JPanel();
        txtKeyword = new JTextField(15);
        cboType = new JComboBox<>(new String[]{"Sinh Viên", "Giảng Viên"});
        btnSearch = new JButton("Tìm");

        pnlTop.add(new JLabel("Từ khóa:"));
        pnlTop.add(txtKeyword);
        pnlTop.add(cboType);
        pnlTop.add(btnSearch);
        add(pnlTop, BorderLayout.NORTH);

        // Bảng kết quả
        tableModel = new DefaultTableModel(new Object[]{"Mã", "Họ Tên", "Địa Chỉ", "Ngày Sinh"}, 0);
        tableResult = new JTable(tableModel);
        add(new JScrollPane(tableResult), BorderLayout.CENTER);
    }

    // Hàm cập nhật dữ liệu lên bảng
    public void updateTableSV(List<SinhVien> list) {
        tableModel.setRowCount(0); // Xóa bảng cũ
        for (SinhVien sv : list) {
            tableModel.addRow(new Object[]{
                    sv.getMaSV(), sv.getTenSV(), sv.getDiaChi(), sv.getNgaySinh()
            });
        }
    }

    public JButton getBtnSearch() { return btnSearch; }
    public JTextField getTxtKeyword() { return txtKeyword; }
    public JComboBox<String> getCboType() { return cboType; }
}