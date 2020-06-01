package inventorymanagement;
/**
 * 
 * @author Inan
 */
public class Item {
    private final String name;
    private final int quantity;
    private final int price;
    private final String origin;

    private Item(String name, int quantity, int price, String origin) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.origin = origin;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getOrigin(){
        return origin;
    }

    public static class Builder{
      private String name;   // 필수
      private int quantity = 0;  // 필수
      private int price = 0;     // 선택
      private String origin; // 선택

      public Builder(String name, int quantity) {
          this.name = name;
          this.quantity = quantity;
      }

      public Builder name(String name) {this.name = name;return this;}
      public Builder quantity(int quantity) {this.quantity = quantity;return this;}
      public Builder price(int price) {this.price = price;return this;}
      public Builder origin(String origin) {this.origin = origin;return this;}

      public Item build(){
        return new Item(name,quantity,price,origin);
      }

    }

    
}
