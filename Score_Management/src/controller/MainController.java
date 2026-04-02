package controller;

import model.DBConnection;
import view.MainView;
import view.SearchView;
import view.ReportView;

public class MainController {
    private MainView view;
    private DBConnection db;

    public MainController(MainView view, DBConnection db) {
        this.view = view;
        this.db = db;

        // Chuyển tab hoặc mở các View con
        this.view.getBtnSearch().addActionListener(e -> {
            new SearchController(new SearchView(), db);
        });

        this.view.getBtnReport().addActionListener(e -> {
            new ReportController(new ReportView(), db);
        });

        this.view.setVisible(true);
    }
}