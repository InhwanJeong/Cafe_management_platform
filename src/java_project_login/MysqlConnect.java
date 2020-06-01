package java_project_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 *
 * @author 20143701 최유래
 */
public class MysqlConnect {

    Connection conn;
    protected SQLSentence sqlsentence;

    public MysqlConnect() {

        try {
            String url = "jdbc:mysql://113.198.234.112:3306/java_team_db?zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&serverTimezone=UTC";
            String user = "inan";
            String pass = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void performSQL() {

        sqlsentence.executeSQL();
        closeConnection();

    }

    public void closeConnection() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        conn = null;
    }
}
