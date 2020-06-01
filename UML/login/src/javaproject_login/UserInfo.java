/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_login;

/**
 *
 * @author yurae
 */
public class UserInfo {
    
    String user_id ;
    String user_password ;
    String user_type;

    public UserInfo() {
        this.user_id = "비회원";
        this.user_type = "non-member";
        this.user_password = "null";
    }


    public String getUser_id() {
        return user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
       
}
