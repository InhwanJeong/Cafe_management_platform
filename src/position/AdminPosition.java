package position;


import java.util.LinkedList;

/**
 *
 * @author K
 */
public class AdminPosition extends Subject{
    private int index;  
    public AdminPosition(){
        observers = new LinkedList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(o);
        }
        
    }
    
    @Override
    public void notifyObserver() {
        for(Observer observer: observers){
            observer.updatedata(index); 
        }
       
    }
    
    public void seatingChanged(){
        notifyObserver();
    }
    public void setSeating(int index){
        this.index = index;
        seatingChanged();
    }
   
}