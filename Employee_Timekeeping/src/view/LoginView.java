package view;


import controller.LoginController;
import javax.swing.*;


public class LoginView extends JFrame {
    public LoginView() {
        setTitle("Đăng nhập");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton btn = new JButton("Login");


        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Username")); add(user);
        add(new JLabel("Password")); add(pass);
        add(btn);


        btn.addActionListener(e ->
                new LoginController().login(user.getText(), new String(pass.getPassword()))
        );
    }
}