/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_project_login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *
 * @20143701 최유래
 * 정규표현식에 맞게 ID와 패스워드 입력
 */
public class SignUpManager {

    UserInfo userinfo = new UserInfo();
    

    private boolean inputUserID() throws IOException {

        String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";

        System.out.print("id를 입력하세요: ");

        String answer = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        answer = in.readLine();

        if (!Pattern.matches(idRegex, answer)) {
            System.out.println("아이디는 '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하로 입력하십시오.");
            return false;
        }

        userinfo.setUserId(answer);
        return true;
    }

    boolean inputUserPassword() throws IOException {

        String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{4,}$";

        String answer = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("password를 입력하세요: ");

        answer = in.readLine();

        userinfo.setUserPassword(answer);

        if (!Pattern.matches(pwPattern, answer)) {
            System.out.println("패스워드는 최소4자리에 영문, 숫자, 특수문자 조합으로 입력하십시오,");
            return false;
        }

        userinfo.setUserType(2);
        return true;
    }

    private void userInfo() throws IOException {
        boolean checkInput = false;

        while (true) {
            checkInput = inputUserID();
            if (checkInput) {
                while (true) {
                    checkInput = inputUserPassword();
                    if (checkInput) {
                        break;
                    }
                }
            }
            if (checkInput) {
                break;
            }
        }
    }

    public void runSignUp() throws IOException {
        userInfo();
        SignUpDB signupdb = new SignUpDB(userinfo);
        signupdb.isSignUpDB();
    }

}
