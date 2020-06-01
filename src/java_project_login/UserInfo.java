package java_project_login;
/**
 *
 * @author 20143701 최유래
 * user정보 클래스
 */
public class UserInfo {
    private String userId;
    private String userPassword;
    private int userType;

    public UserInfo(){
        this.userType = 2; 
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
}
