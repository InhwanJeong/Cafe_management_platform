package java_project_login;

/**
 *
 * @author 20143701 최유래
 * state pattern
 * 로그인 실패 상태 : 로그인 실패. 다시 입력받도록 입력받지 않은 상태로 설정
 */


class FailState implements State {

    LoginScreen loginscreen;

    public FailState(LoginScreen loginscreen) {
        this.loginscreen = loginscreen;
    }

    @Override
    public boolean resultPrint() {
        System.out.println("로그인 실패!!");
        loginscreen.setState(loginscreen.getNotInputState());
        return false;
    }

    @Override
    public UserInfo inputData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compareDB(UserInfo userinfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
