/*
 * 객체 정의
 */
package productsmenu;

/**
 * @author Ahn Junhong
 */
public class MenuItem {
    String tag;
    String name;
    String description;
    String price;
    
    public MenuItem(String tag,
                    String name,
                    String description,
                    String price) {
        this.tag = tag;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public String getTag() {
        return tag;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getPrice() {
        return price;
    }
}
