package position;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K
 */
public class Displaysave1 implements Observer, DisplayElement {

    private AdminPosition adminposition;
    SeatDB sd = new SeatDB();
    String temp;
    int key;
    int key1;
    Scanner scan = new Scanner(System.in);

    public Displaysave1(AdminPosition adminposition) {
        this.adminposition = adminposition;
        adminposition.registerObserver(this);
    }

    @Override
    public void updatedata(int index) {
        if(index>0){
            try {
                sd.updateData(index);
            } catch (SQLException ex) {
                Logger.getLogger(Displaysave1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(index<0){
            index=-index;
            try {
                sd.removeData(index);
            } catch (SQLException ex) {
                Logger.getLogger(Displaysave1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            

    }

    

    public void menu() throws SQLException {
        sd.searchData();
        while (true) {
            System.out.println("\n1) 자리예약  2) 자리삭제  3) 이전화면");
            key = scan.nextInt();
            
            switch (key) {
                case 1:
                    updatedataTrue();
                    display();
                    break;
                case 2:
                    updatedataFalse();
                    display();
                    break;
                default:
                    System.out.println("다시 입력해주세요");
                    break;
            }
            if (key == 3) {
                break;
            }
        }
    }

    @Override
    public void display() {
        try {
            sd.searchData();
        } catch (SQLException ex) {
            Logger.getLogger(Displaysave1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updatedataTrue() throws SQLException {
        sd.searchData();
        System.out.print("\n예약하고싶은 좌석을 선택해주세요 : ");
        key1 = scan.nextInt();
        updatedata(key1);

    }

    public void updatedataFalse() throws SQLException {
        sd.searchData();
        System.out.println("삭제하고싶은 좌석을 선택해주세요");
        key1 = scan.nextInt();
        key1=-key1;
        updatedata(key1);
    }

}
