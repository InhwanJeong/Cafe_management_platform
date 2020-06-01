/*
 * concreteAggregate / Aggregate 하위 클래스
 * 차 항목 생성
 */
package productsmenu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Ahn Junhong
 */
public class TeaItem implements Aggregate {
    ArrayList menuItem;
    
    public TeaItem() {
        menuItem = new ArrayList();
        
        addItem("HOT","홍차","단맛","3,000");
        addItem("HOT","녹차","깔끔함","2,000");
        addItem("NEW","백차","깔끔함","3,000");
        addItem("---","황차","쌉쌀함","3,500");
        addItem("NEW","오룡차","짙은향","3,500");
        addItem("---","흑차","쓴맛","4,000");
        addItem("---","보이차","깔끔함","3,000");
        addItem("NEW","화차차","부드러움","3,500");
    }
    
    public void addItem(String tag, String name, String description, String price) {
        MenuItem menuTea = new MenuItem(tag, name, description, price);
        menuItem.add(menuTea);
    }
    
    public ArrayList getMenuItems() {
        return menuItem;
    }

    @Override
    public Iterator createIterator() {
        return menuItem.iterator();
    }
}
