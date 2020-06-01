/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// mysql 연결
public abstract class DBConn {

    Connection con;
    Statement stmt;
    ResultSet rs;

    String url = "jdbc:mysql://localhost:3306/java_project?characterEncoding=UTF-8&serverTimezone=UTC";

    boolean connectionDB(int key) {
        
        boolean ischeck = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        getConnetion();
        
        switch (key) {
            case 1:
                ischeck = getData();
                break;
            case 3:
                setData();
                break;
        }
        closeConnection();
        return ischeck;
    }

    //연결
    void getConnetion() {
        try {
            con = DriverManager.getConnection(url, "root", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean getData() {
        return true;
    }
    
    void setData() {
    }
    //자원 반환
    void closeConnection() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
