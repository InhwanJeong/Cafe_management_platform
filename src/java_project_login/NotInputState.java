/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project_login;

import java.io.*;

/**
 *
 * @author 20143701 최유래
 * state pattern
 * 입력을 받지 않은 상태 : 입력을 받는다.
 */
public class NotInputState implements State {

    LoginScreen loginscreen;

    public NotInputState(LoginScreen loginscreen) {
        this.loginscreen = loginscreen;
    }

    @Override
    public boolean resultPrint() {
        System.out.println("입력해주세요");
        return false;
    }

    @Override
    public UserInfo inputData() {
        UserInfo userinfo = new UserInfo();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("ID : ");
            userinfo.setUserId(in.readLine());
            System.out.print("PASSWORD : ");
            userinfo.setUserPassword(in.readLine());

        } catch (IOException ioe) {
            System.err.println(ioe);
        }
        loginscreen.setState(loginscreen.getInputState(userinfo));
        return userinfo;
    }

    @Override
    public boolean compareDB(UserInfo userinfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
