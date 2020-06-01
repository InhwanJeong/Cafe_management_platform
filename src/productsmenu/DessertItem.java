/*
 * concreteAggregate / Aggregate 하위 클래스
 * 디저트 항목 생성
 */
package productsmenu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Ahn Junhong
 */
public class DessertItem implements Aggregate {
    ArrayList menuItem;
    
    public DessertItem() {
        menuItem = new ArrayList();
        
        addItem("HOT","티라미수","부드러움","5,000");
        addItem("HOT","파르페","말랑말랑","6,400");
        addItem("NEW","보코노토","부드러움","5,600");
        addItem("NEW","스폴리아텔레","바삭함","6,700");
        addItem("NEW","타르투포","말랑말랑","7,100");
        addItem("NEW","마시멜로","매우 말랑말랑","7,400");
        addItem("NEW","피그놀라타","가변적","7,800");
        addItem("NEW","제폴라","부드러움","7,800");
    }
    
    public void addItem(String tag, String name, String description, String price) {
        MenuItem menuDessert = new MenuItem(tag, name, description, price);
        menuItem.add(menuDessert);
    }
    
    public ArrayList getMenuItems() {
        return menuItem;
    }

    @Override
    public Iterator createIterator() {
        return menuItem.iterator();
    }
}
