/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_login;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author yurae DB에 회원정보 삽입 (아이디 있거나, 자리수 초과하거나 모자라면 다시 입력하세요), 비밀번호도
 * 
 *
 */
public class InsertData extends DBConn {

    private String user_id;
    private String user_password;
    private String user_type;

    private boolean inputUserID() {

        String idRegex = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";

        System.out.println("id를 입력하세요");

        String answer = null;
        Scanner scan = new Scanner(System.in);
        answer = scan.nextLine();
        if (Pattern.matches(idRegex, answer) == false) {
            System.out.println("아이디는 '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하로 입력하십시오.");
            return false;
        }
        this.user_id = answer;
        return true;
    }

    boolean inputUserPassword() {

        String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{4,}$";

        String answer = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("password를 입력하세요");

        answer = scan.nextLine();
        this.user_password = answer;
        System.out.println(Pattern.matches(pwPattern, answer));
        if (Pattern.matches(pwPattern, answer) == false) {
            System.out.println("패스워드는 최소4자리에 영문, 숫자, 특수문자 조합으로 입력하십시오,");
            return false;
        }

        this.user_type = "member";
        return true;
    }

    @Override
    public void setData() {

        userInfo();

        try {

            String sql = "insert into user(userId, userpassword, usertype) values";
            sql += "('" + user_id + "','" + user_password + "','" + user_type + "')";

            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void userInfo() {
        boolean checkInput = false;

        while (true) {
            checkInput = inputUserID();
            System.out.println(checkInput);
            if (checkInput == true) {
                while (true) {
                    checkInput = inputUserPassword();
                    System.out.println(checkInput);
                    if (checkInput == true) {
                        break;
                    }
                }
            }
            if (checkInput == true) {
                break;
            }
        }
    }

}
