package java_project_login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 20143701 최유래 
 * strategy pattern
 * SQLSentence 인터페이스 구현
 */

class InsertSQL implements SQLSentence {

    Connection conn;
    Statement stmt;
    UserInfo userinfo;

    public InsertSQL(Connection conn, UserInfo userinfo) {
        this.conn = conn;
        this.userinfo = userinfo;
    }

    @Override
    public boolean executeSQL() {
        try {
            
           String sql = "insert into user(userid, userpassword, usertype) values";
            sql += "('" + userinfo.getUserId() + "','" + userinfo.getUserPassword() + "'," 
                    + userinfo.getUserType() + ")";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
        }
        return true;
    }

}
