package hello.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chanduk on 13/05/15.
 */

interface Subject {

    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getEmailDetails(Observer obj);
    public void sendNotification(Notification mode);
}



public class Order implements Subject{

    public void setOrderCreated(boolean orderCreated) {
        this.orderCreated = orderCreated;
    }

    private boolean orderCreated = false;
    private Map<Product,Integer> products;
    private int total;
    private Customer user;
    private List<Observer> observers;
    private String message;


    public Order(Cart cart){
        this.products = cart.getProducts();
        this.user = cart.getUser();
        this.total = cart.getTotal();
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if(!observers.contains(obj)){
            observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        if(observers.contains(obj)){
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        if(orderCreated){
            for(Observer obs : observers){
                obs.update();
            }
            orderCreated = false;
        }
    }
    @Override
    public String getEmailDetails(Observer obj) {
        return "Email Details";
    }

    @Override
    public void sendNotification(Notification mode) {
        mode.sendNotification();
    }
}
