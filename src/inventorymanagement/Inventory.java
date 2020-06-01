package inventorymanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;        
import java.sql.SQLException;

public class Inventory {
    String name;
    int quantity;
    int price;
    String origin;
    BufferedReader in;
    DatabaseManagement db;
    String temp;

    public Inventory() {
        in = new BufferedReader(new InputStreamReader(System.in));
        db = new DatabaseManagement();
    }

    public void showmenu() throws IOException, SQLException {
        while(true){
            System.out.println("관리자 재고 관리 시스템입니다. "
                    + "\n1)재고목록   2)재고추가   3)재고제거   4)재고수량관리   5)돌아가기");
            temp = in.readLine();
            int selectNumber = Integer.parseInt(temp);

            switch(selectNumber){
                case 1:
                    checkList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    itemManage();
                    break;    
                default:
                    break;
            }
            if(selectNumber == 5) break;
        } 
    }

    public void addItem() throws SQLException {       
        System.out.println("----- 재고 추가옵션입니다 ----- ");
        
        try {
            System.out.print("이름 입력:");
            name = in.readLine();
            System.out.print("수량 입력:");
            temp = in.readLine();
            quantity = Integer.parseInt(temp);
            System.out.print("가격 입력:");
            temp = in.readLine();
            price = Integer.parseInt(temp);
            System.out.print("원산지 입력:");
            origin = in.readLine();
        } catch (IOException e) {
        }       
        Item item = new Item.Builder(name, quantity).price(price).origin(origin).build();
        db.insertData(item);
    }

    public void removeItem() throws IOException, SQLException {
        System.out.print("제거할 재고의 이름을 입력하세요: ");
        temp = in.readLine();
        db.deleteData(temp);
    }

    public void checkList() throws SQLException{
        db.searchData();
    }

    public void itemManage() throws IOException, SQLException {
        System.out.print("수정할 재고의 이름을 입력하세요: ");
        name = in.readLine();
        System.out.print("재고의 수량을 입력하세요: ");
        temp = in.readLine();
        quantity = Integer.parseInt(temp);
        db.updateData(name, quantity);
    }
    
}
