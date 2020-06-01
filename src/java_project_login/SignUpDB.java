package java_project_login;
/**
 *
 * @author 20143701 최유래
 * strategy pattern
 * inserSQL을 구성한 회원가입 객체
 */
class SignUpDB extends MysqlConnect {

    public SignUpDB(UserInfo userinfo) {
        sqlsentence = new InsertSQL(conn, userinfo);
    }

    public boolean isSignUpDB() {
        return sqlsentence.executeSQL();
    }

}
