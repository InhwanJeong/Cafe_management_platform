/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project_login;

/**
 *
 * @author 20143701 최유래
 * state pattern
 * 입력을 한 상태 : DB에 있는 값과 입력한 값을 비교한뒤 ture, false 에따라 상태 변경
 */
public class InputState implements State {
    
    LoginScreen loginscreen;
    UserInfo userinfo;

    InputState(LoginScreen loginscreen,UserInfo userinfo) {
             this.loginscreen = loginscreen;
             this.userinfo = userinfo;
    }

    @Override
    public boolean resultPrint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo inputData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compareDB(UserInfo userinfo) {
        boolean check = false;
        LoginDB logindb = new LoginDB(userinfo);
        check = logindb.isLogin();
        if(check){
            loginscreen.setState(loginscreen.getSuccessState());
        }else{
            loginscreen.setState(loginscreen.getFailState());
        }
        return check;
    }
       
}
