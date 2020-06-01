package java_project_login;
/**
 *
 * @author 20143701 최유래
 * strategy pattern
 * SelectSQL을 구성한 로그인 객체
 */


public class LoginDB extends MysqlConnect {

    public LoginDB(UserInfo userinfo) {
        sqlsentence = new SelectSQL(conn, userinfo);
    }

    public boolean isLogin() {
        return sqlsentence.executeSQL();
    }


}
