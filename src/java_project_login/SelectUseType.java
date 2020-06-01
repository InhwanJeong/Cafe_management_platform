/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project_login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 20143701 최유래 로그인, 비회원으로 이용, 회원가입, 프로그램 종료 선택
 */
public class SelectUseType {

    UserInfo userinfo;

    public UserInfo runSelectUseType() throws IOException {
        
        int input;
        boolean ischeck = false;

        while (!ischeck) {

            System.out.println("선택하십시오");
            System.out.println("1) 로그인   2) 회원가입   3) 이전화면");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(in.readLine());

            switch (input) {
                case 1:
                    LoginManager loginManager = new LoginManager();
                    userinfo = loginManager.runLogin();
                    ischeck = true;
                    break;

                case 2:
                    SignUpManager signUpManager = new SignUpManager();
                    signUpManager.runSignUp();
                    System.out.println("회원가입 성공!!");
                    break;
                case 3:
                    userinfo = new UserInfo();
                    ischeck = true;          
                    break;
                default:
                    System.out.println("다시 선택하십오.");
            }
        }
        System.out.println(userinfo.getUserType());
        return userinfo;
    }

}
