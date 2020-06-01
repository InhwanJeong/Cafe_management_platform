/*
 * concreteAggregate / Aggregate 하위 클래스
 * 커피 항목 생성
 */
package productsmenu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Ahn Junhong
 */
public class CoffeeItem implements Aggregate {
    ArrayList menuItem;
    
    public CoffeeItem() {
        menuItem = new ArrayList();
        
        addItem("---","에스프레소","쓴맛","3,000");
        addItem("HOT","아메리카노","쓴맛","2,000");
        addItem("HOT","카라멜 마끼아또","단맛","4,000");
        addItem("---","카페모카","부드러움","3,500");
        addItem("---","카푸치노","단맛","3,500");
        addItem("NEW","플랫 화이트","부드러움","5,000");
        addItem("NEW","아인슈페너","차가움","4,500");
    }
    
    public void addItem(String tag, String name, String description, String price) {
        MenuItem menuCoffee = new MenuItem(tag, name, description, price);
        menuItem.add(menuCoffee);
    }
    
    public ArrayList getMenuItems() {
        return menuItem;
    }
    
    @Override
    public Iterator createIterator() {
        return menuItem.iterator();
    }
}
