/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_login;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yurae id,password 입력 한 뒤 입력한 것과 비교
 *
 */
public class ComparisonId extends DBConn {

    UserInfo userIfo = new UserInfo();

    @Override
    public boolean getData() {

        String user_id = inputUserId();
        boolean idCheck = false;
        boolean passwordCheck = false;
        String inputPassword;
        String getPass;

        try {

            String sql = "select * from user where userId =";
            sql += "'" + user_id + "'";

//            System.out.println(sql);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            idCheck = rs.next();

            if (idCheck == true) {

//                System.out.println(rs.getString("userId"));
                inputPassword = inputUserPassword();
                getPass = rs.getString("userpassword");

                if (getPass.equals(inputPassword)) {
                    System.out.println("login success!!!");
                    userIfo.user_type = rs.getString("usertype");
                    userIfo.user_id = rs.getString("userid");
                    userIfo.user_password = rs.getString("userpassword");
                    System.out.println("회원 type : " + userIfo.user_type);

                } else {
                    System.out.println("잘못된 비밀번호입니다.");
                    return false;
                }
            } else {
                System.out.println("잘못된 아이디입니다.");
                return false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComparisonId.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private String inputUserId() {
        String answer = null;
        System.out.println("id를 입력하세요");
        answer = inputUserInfo();
        return answer;
    }

    private String inputUserPassword() {
        String answer = null;
        System.out.println("password 를 입력하세요");
        answer = inputUserInfo();
        return answer;
    }

    private String inputUserInfo() {

        String answer = null;

        Scanner scan = new Scanner(System.in);

        answer = scan.next();

        return answer;
    }

    public UserInfo getUserIfo() {
        return userIfo;
    }

}
