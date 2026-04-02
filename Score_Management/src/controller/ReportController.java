package controller;

import dao.LopDAO;
import model.DBConnection;
import view.ReportView;

public class ReportController {
    private ReportView view;
    private LopDAO lopDAO;

    public ReportController(ReportView view, DBConnection db) {
        this.view = view;
        this.lopDAO = new LopDAO(db);

        // Sự kiện nút Thống kê
        this.view.getBtnThongKe().addActionListener(e -> showReport());
        this.view.setVisible(true);
    }

    private void showReport() {
        // Ví dụ: lấy số lượng SV của một lớp đang chọn trong ComboBox
        String maLop = (String) view.getCboLop().getSelectedItem();
        int soLuong = lopDAO.getSoSVDaLop(maLop);
        view.getLblResult().setText("Số sinh viên: " + soLuong);
    }
}