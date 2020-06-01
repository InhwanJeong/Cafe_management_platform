package inventorymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManagement {
    Connection conn = null;
    Statement stmt = null;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs;
    String table;
    String url = "jdbc:mysql://113.198.234.112:3306/java_team_db?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&serverTimezone=UTC"; 
    String user = "inan"; // 계정명
    String pw = "1234"; // 비밀번호
    String sql;
    public enum DB {
        INSERT, DELETE, UPDATE, SEARCH  
    }
    
    private void dbconnect(DB commandCheck) throws SQLException{
        try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection( url, user, pw);
              // 접속에 성공했으므로 쿼리문을 실행할 수 있다.
              // ↓↓↓↓↓↓↓↓ 쿼리문 작성 가능 ↓↓↓↓↓↓↓↓
              // 쿼리수행 객체
              // 접속 수행후 -> SQL
              // prepareStatement : DML ( insert, update, delete ) 담당
              stmt = con.createStatement(); 
              switch(commandCheck){
                  case SEARCH:
                      rs = stmt.executeQuery(sql);
                      while(rs.next()){ 
                            System.out.println("이름 : " + rs.getString("name") 
                                    + "\t수량 : " + rs.getString("quantity") 
                                    + "\t가격 : " + rs.getString("price")
                                    + "\t원산지: " + rs.getString("origin")); 
                      } 
                      break; 
                  case INSERT:
                  case DELETE: 
                  case UPDATE:     
                    pstmt = con.prepareStatement(sql);
                    pstmt.executeUpdate();
                    break;
                  default:
                      break;
              }       
          } catch (ClassNotFoundException e){
              System.out.println( "드라이버가 존재하지 않습니다" );
          }catch(NullPointerException e){              
          }finally{
            if(stmt != null)stmt.close();
            if(con != null)con.close();
            if(rs != null)rs.close();
        }
    }

    public void insertData(Item item) throws SQLException {
        sql = "insert into item(name, quantity, price, origin)";
        sql += " values("
                + "'" + item.getName() + "',"
                + item.getQuantity()+","
                + item.getPrice()+","
                + "'" + item.getOrigin()+"');";
        dbconnect(DB.INSERT);
    }

    public void deleteData(String name) throws SQLException {
        sql = "delete from item where name='";
        sql += name + "'";
        dbconnect(DB.DELETE);
    }

    public void updateData(String name, int quantity) throws SQLException {
        sql = "update item set quantity=" + quantity;
        sql += " where name='" + name +"'";
        dbconnect(DB.UPDATE);
    }
    public void searchData() throws SQLException{
        sql = "select * from item";        
        dbconnect(DB.SEARCH);
    }
}
