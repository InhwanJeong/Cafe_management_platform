/*
 * 메뉴 관리
 * 관리자는 메뉴 항목을 확인할 수 있다..
 * 현재까지는 1을 입력하면 처음으로
 */
package productsmenu;

import java.util.Scanner;

/**
 * @author Ahn Junhong
 */
public class ConfirmProduct {
    Scanner scn = new Scanner(System.in);
    int inputNum = 0;
    CoffeeItem coffee = new CoffeeItem();
    TeaItem tea = new TeaItem();
    DessertItem dessert = new DessertItem();
    
    public ConfirmProduct() {
        /* basic output */
        System.out.println("메뉴 관리");
        System.out.println("1)커피    2) 차    3) 디저트    4) 뒤로");
        
        System.out.print("입력 : ");
        inputNum = scn.nextInt();
        
        /* input */
        switch(inputNum) {
            case 1:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                break;
            case 2:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                break;
            case 3:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                break;
            case 4:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                break;
            default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오.");
        }
    }
}
