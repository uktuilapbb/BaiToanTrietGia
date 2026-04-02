package util;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Kết nối MySQL thành công!");
        } else {
            System.out.println("Kết nối MySQL thất bại!");
        }
    }
}
