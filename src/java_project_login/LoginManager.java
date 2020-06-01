package java_project_login;

/**
 *
 * @author 20143701 최유래
 * 로그인 진행순서
 * 
 */
public class LoginManager {

    LoginScreen loginScreen;
    UserInfo userinfo;
    boolean isInput;
    
    public LoginManager(){
        this.loginScreen = new LoginScreen();
        this.userinfo = new UserInfo();
        this.isInput = false;
    }

    public UserInfo runLogin() {
        
        while (!isInput) {
            isInput = loginScreen.resultPrint();
            userinfo = loginScreen.inputData();
            loginScreen.compareDB(userinfo);
            isInput = loginScreen.resultPrint();
        }
        return userinfo;
    }
    
}
