package java_project_login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20143701 최유래 strategy pattern SQLSentence 인터페이스 구현
 */
class SelectSQL implements SQLSentence {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    UserInfo userinfo;

    public SelectSQL(Connection conn, UserInfo userinfo) {
        this.conn = conn;
        this.userinfo = userinfo;
    }

    public boolean executeSQL() {

        String sql = "select * from user where userid =";
        sql += "'" + userinfo.getUserId() + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next() && userinfo.getUserPassword().equals(rs.getString("userpassword"))) {
                    userinfo.setUserType(rs.getInt("usertype"));
                    return true;
                }
            } catch (SQLException ex) {
            Logger.getLogger(SelectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
                return false;
        }
    }

