package position;


/**
 *
 * @author K
 */
public class DisplaySetting implements Observer,DisplayElement{
    private int index;
    private Subject position;
    
    public DisplaySetting(Subject position){
        this.position = position;
        position.registerObserver(this);
    }

    @Override
    public void updatedata(int index) {
        this.index = index;
    }

    @Override
    public void display() {
    }
    
}
