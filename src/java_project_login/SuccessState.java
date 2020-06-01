package java_project_login;

/**
 *
 * @author 20143701 최유래
 * state pattern
 * 로그인 성공 상태 : 로그인 성공. 로그인 성공이라는 결과를 출력 
 */

class SuccessState implements State {

    LoginScreen loginscreen;

    public SuccessState(LoginScreen loginscreen) {
        this.loginscreen = loginscreen;
    }

    public boolean resultPrint() {
        System.out.println("로그인 성공!!");
        return true;
    }

    public UserInfo inputData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compareDB(UserInfo userinfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
