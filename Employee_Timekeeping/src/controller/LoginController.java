package controller;


import dao.UserDAO;
import model.User;
import view.*;


public class LoginController {
    public void login(String u, String p) {
        User user = new UserDAO().login(u, p);
        if (user != null) {
            if (user.getRole().equals("OWNER")) new OwnerDashboardView().setVisible(true);
            else new EmployeeView(user).setVisible(true);
        }
    }
}