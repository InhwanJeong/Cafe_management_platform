/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allmenu;

import productsmenu.ProductMenu;
import position.*;
import membership.*;
import java_project_login.*;
import inventorymanagement.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author Inan
 */
public class MainMenu {
    private String temp;
    private final BufferedReader in;
    UserInfo userinfo;
    SelectUseType sut;
    AdminPosition adminposition;
    Displaysave1 displaysave1;
    SeatDB sb;
    ProductMenu pm;
    
    public MainMenu() throws IOException, SQLException{
         adminposition = new AdminPosition();
         displaysave1 = new Displaysave1(adminposition);
         in = new BufferedReader(new InputStreamReader(System.in));
         userinfo = new UserInfo();
         sut = new SelectUseType();  
         sb = new SeatDB();
         pm = new ProductMenu();
    }
        
    public void showmenu() throws IOException, SQLException{
         while(true){
            System.out.println("어서오세요! 카페관리 시스템입니다. "
                + "\n1) 메뉴   2) 좌석   3) 로그인   4) 종료");
            temp = in.readLine();
            int selectNumber = Integer.parseInt(temp);

            switch(selectNumber){
                case 1:
                    pm.printMenu();
                    break;
                case 2:
                    sb.searchData();
                    break;
                case 3:
                    userinfo = sut.runSelectUseType();
                    if(userinfo.getUserType() == 1)
                        showAdminmenu();
                    else if(userinfo.getUserType() <= 4 && userinfo.getUserType() >1)
                        showMenbermenu();
                    break;   
                default:
                    break;
            }
            if(selectNumber == 4) {
                System.out.println("감사합니다! 또 이용해 주시길 바랍니다!");
                break;
            }
                
        } 
    }
    
    private void showMenbermenu() throws IOException, SQLException{        
        while(true){
            System.out.println("어서오세요! 회원님 카페관리 시스템입니다. "
                + "\n1) 메뉴   2) 좌석   3) 멤버십   4) 로그아웃");
            temp = in.readLine();
            int selectNumber = Integer.parseInt(temp);

            switch(selectNumber){
                case 1:
                    pm.printMenu();
                    break;
                case 2:
                    displaysave1.menu();
                    break;
                case 3:
                    Client membership = new Client();
                    int level = userinfo.getUserType();
                    membership.runMembership(level);
                    break;   
                default:
                    break;
            }
            if(selectNumber == 4) break;
        }
    }
    
    private void showAdminmenu() throws IOException, SQLException{        
        while(true){
            System.out.println("어서오세요! 관리자님 카페관리 시스템입니다. "
                + "\n1) 메뉴   2) 좌석   3) 재고관리   4) 로그아웃");
            temp = in.readLine();
            int selectNumber = Integer.parseInt(temp);

            switch(selectNumber){
                case 1:
                    pm.printMenu();;
                    break;
                case 2:
                     displaysave1.menu();
                    break;
                case 3:
                    Inventory a = new Inventory();
                    a.showmenu(); 
                    break;   
                default:
                    break;
            }
            if(selectNumber == 4) break;
        }
    }
}
