package view;


import model.User;
import dao.AttendanceDAO;


import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EmployeeView extends JFrame {
    private User user;
    private JLabel statusLabel;


    public EmployeeView(User user) {
        this.user = user;


        setTitle("Nhân viên - " + user.getFullName());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel nameLabel = new JLabel("Xin chào: " + user.getFullName());
        statusLabel = new JLabel("Trạng thái: CHƯA CHẤM CÔNG");


        JButton btnCheckIn = new JButton("Chấm công vào");
        JButton btnCheckOut = new JButton("Chấm công ra");
        JButton btnLeave = new JButton("Gửi đơn xin nghỉ");


        btnCheckIn.addActionListener(e -> checkIn());
        btnCheckOut.addActionListener(e -> checkOut());
        btnLeave.addActionListener(e -> sendLeaveRequest());


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(nameLabel);
        add(statusLabel);
        add(btnCheckIn);
        add(btnCheckOut);
        add(btnLeave);
    }


    private void checkIn() {
        String time = now();
        statusLabel.setText("Đã chấm công vào lúc: " + time);
// AttendanceDAO.insertCheckIn(user.getId(), time);
    }


    private void checkOut() {
        String time = now();
        statusLabel.setText("Đã chấm công ra lúc: " + time);
// AttendanceDAO.updateCheckOut(user.getId(), time);
    }


    private void sendLeaveRequest() {
        JOptionPane.showMessageDialog(this,
                "Đã gửi đơn xin nghỉ (demo)");
    }


    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"));
    }
}