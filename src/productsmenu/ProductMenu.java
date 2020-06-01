/*
 * version 0.4
 * 주문 예약 메뉴
 * 커피, 차, 디저트 중 원하는 메뉴를 선택할 수 있다.
 */
package productsmenu;

import java.util.Scanner;

/**
 * @author Ahn Junhong
 */
public class ProductMenu {
    private Scanner scn = new Scanner(System.in);
    private int inputNum = 0;
    CoffeeItem coffee = new CoffeeItem();
    TeaItem tea = new TeaItem();
    DessertItem dessert = new DessertItem();
    MenuPrint printMenu = new MenuPrint(coffee, tea, dessert);
    
    public void printMenu() {
        /* basic output */
        do {
        System.out.println("**************************************");
        System.out.println("*                 메뉴                *");
        System.out.println("**************************************");
        System.out.println("    *********  *******  **********");
        System.out.println("    * 1 커피 * * 2 차 * * 3 디저트 *");
        System.out.println("    *********  *******  **********");
        System.out.println("        원하는 항목을 선택하세요!");
        System.out.println("   '4'를 입력하면 처음으로 돌아갑니다.");
        System.out.println("**************************************");
        
        /* input */ 
        
        System.out.print("입력 : ");
        inputNum = scn.nextInt();
        
        switch(inputNum) {
            case 1:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                printMenu.printCoffee();
                break;
            case 2:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                printMenu.printTea();
                break;
            case 3:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                printMenu.printDessert();
                break;
            case 4:
                for(int clear=0 ; clear<20 ; clear++)
                    System.out.println();
                break;
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오.");
            }
            if(inputNum == 4) break;
        } while (true);      
    }
}

