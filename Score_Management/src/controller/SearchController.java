package controller;

import dao.SinhVienDAO;
import dao.GiangVienDAO;
import model.DBConnection;
import model.SinhVien;
import view.SearchView;
import java.util.List;

public class SearchController {
    private SearchView view;
    private SinhVienDAO svDAO;
    private GiangVienDAO gvDAO;

    public SearchController(SearchView view, DBConnection db) {
        this.view = view;
        this.svDAO = new SinhVienDAO(db);
        this.gvDAO = new GiangVienDAO(db);

        // Sự kiện nút Tìm kiếm
        this.view.getBtnSearch().addActionListener(e -> performSearch());
        this.view.setVisible(true);
    }

    private void performSearch() {
        String keyword = view.getTxtKeyword().getText();
        String type = (String) view.getCboType().getSelectedItem(); // SV hoặc GV

        if ("Sinh Viên".equals(type)) {
            List<SinhVien> result = svDAO.searchByTenSV(keyword);
            view.updateTableSV(result); // Cập nhật dữ liệu lên JTable
        } else {
            // Logic tương tự cho GiangVien
        }
    }
}