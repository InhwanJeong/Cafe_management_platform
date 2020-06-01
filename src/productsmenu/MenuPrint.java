/*
 * 회원,비회원 메뉴 출력
 */
package productsmenu;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Ahn Junhong
 */
public class MenuPrint {
    Scanner scn = new Scanner(System.in);
    int inputNum = 0;
    Aggregate coffeeItem;
    Aggregate teaItem;
    Aggregate dessertItem;
    ProductMenu productMenu;
    
    public MenuPrint(Aggregate coffeeItem, Aggregate teaItem, Aggregate dessertItem) {
        this.coffeeItem = coffeeItem;
        this.teaItem = teaItem;
        this.dessertItem = dessertItem;
    }
    
    public void printCoffee() {
        Iterator CoffeeIterator = coffeeItem.createIterator();
        System.out.println("--- COFFEE ---");
        printMenu(CoffeeIterator);
        printGoBack();
    }
    
    public void printTea() {
        Iterator TeaIterator = teaItem.createIterator();
        System.out.println("--- TEA ---");
        printMenu(TeaIterator);
        printGoBack();
    }
    
    public void printDessert() {
        Iterator DessertIterator = dessertItem.createIterator();
        System.out.println("--- DESSERT ---");
        printMenu(DessertIterator);
        printGoBack();
    }
    
    public void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.print(menuItem.getTag() + ", ");
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getDescription() + ", ");
            System.out.println(menuItem.getPrice());
        }
    }
    
    public void printGoBack() {
        /* basic output */
        System.out.println("**************************************");
        System.out.println("    뒤로 가시려면 '1'을 입력해 주세요.");
        System.out.println("**************************************");
        
        /* input */
         do {
             System.out.print("입력 : ");
             inputNum = scn.nextInt();

             if ( inputNum == 1 ) {
                 for(int clear=0 ; clear<20 ; clear++)
                     System.out.println();
                 break;
             }
                  System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오.");
             } while ( inputNum!=1 );
    }
}
