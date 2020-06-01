/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_login;

import java.util.Scanner;

/**
 *
 * @author yurae
 */
public class SelectionMemberType {

    UserInfo typeOfMemberUsed = new UserInfo();

    public void selectMemberType() {

        Scanner scan = new Scanner(System.in);
        int input;
        boolean ischeck = false;

        while (ischeck == false) {

            System.out.println("선택하십시오");
            System.out.println("1. 로그인  2. 비회원으로 이용 3. 회원가입 4.프로그램 종료");

            input = scan.nextInt();

            switch (input) {
                case 1:
                    ComparisonId ci = new ComparisonId();
                    ischeck = ci.connectionDB(input);
                    typeOfMemberUsed = ci.getUserIfo();
                    System.out.println("type : " + typeOfMemberUsed.user_type);
                    break;
                case 2:
                    typeOfMemberUsed = new UserInfo();
                    System.out.println("type : " + typeOfMemberUsed.user_type);
                    ischeck = true;
                    break;
                case 3:
                    InsertData insertdata = new InsertData();
                    insertdata.connectionDB(input);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("다시 선택하십오.");
            }
        }
    }

}
