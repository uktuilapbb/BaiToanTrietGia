package Database;

import Database.DBConnection;
import java.sql.Connection;

public class QLSV {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println(" IntelliJ và MySQL QuanLiSV ĐÃ KẾT NỐI");
        }
    }
}
