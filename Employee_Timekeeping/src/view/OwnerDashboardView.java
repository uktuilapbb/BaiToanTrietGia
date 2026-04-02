package view;


import dao.AttendanceDAO;
import model.Attendance;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class OwnerDashboardView extends JFrame {
    public OwnerDashboardView() {
        setTitle("OWNER DASHBOARD");
        setSize(800, 400);
        setLocationRelativeTo(null);


        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Nhân viên", "Trạng thái", "Giờ vào", "Giờ ra"}, 0
        );
        JTable table = new JTable(model);
        add(new JScrollPane(table));


        new AttendanceDAO().getToday().forEach(a -> model.addRow(
                new Object[]{a.getFullName(), a.getStatus(), a.getCheckIn(), a.getCheckOut()==null?"---":a.getCheckOut()}
        ));
    }
}