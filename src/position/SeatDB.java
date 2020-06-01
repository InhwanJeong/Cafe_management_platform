package position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 *
 *
 */
public class SeatDB {

    Connection conn = null;
    Statement stmt = null;
    Connection con;
    ResultSet rs;
    PreparedStatement pstmt;
    String table;
    String url = "jdbc:mysql://113.198.234.112:3306/java_team_db?zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&serverTimezone=UTC";
    String user = "inan";
    String pw = "1234";
    String sql;

    public enum DB {
        UPDATE, SEARCH
    }

    private void dbconnect(DB commandCheck) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);

            stmt = con.createStatement();
            switch (commandCheck) {
                case SEARCH:
                    rs = stmt.executeQuery(sql);
                    System.out.println("\n----------------------------");
                    while (rs.next()) {

                        if (!rs.getBoolean("reserveseat")) {
                            System.out.print("□ ");
                        } else if (rs.getBoolean("reserveseat")) {
                            System.out.print("■ ");
                        }
                    }
                    System.out.println("\n----------------------------");

                    break;
                case UPDATE:
                    pstmt = con.prepareStatement(sql);
                    pstmt.executeUpdate();
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다");
        } finally {
            if(stmt != null)stmt.close();
            if(con != null)con.close();
            if(rs != null)rs.close();
        }
    }

    public void searchData() throws SQLException {
        sql = "select * from seat";
        dbconnect(DB.SEARCH);
    }

    public void updateData(int seatnum) throws SQLException {
        sql = "update seat set reserveseat = 1 where seatnum = ";
        sql += seatnum;
        dbconnect(DB.UPDATE);
    }

    public void removeData(int seatnum) throws SQLException {
        sql = "update seat set reserveseat = 0 where seatnum = ";
        sql += seatnum;
        dbconnect(DB.UPDATE);

    }
}
