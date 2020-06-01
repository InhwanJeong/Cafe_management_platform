package java_project_login;

public interface State {
   public boolean resultPrint();
   public UserInfo inputData() ;
   public boolean compareDB(UserInfo userinfo);
}
