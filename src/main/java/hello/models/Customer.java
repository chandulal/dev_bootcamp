package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */
public class Customer {
    private int userId;
    private String userName;
    private String email;

    public String getEmail() {
        return email;
    }
    public Customer(int userId, String userName, String email) {
        this.userId=userId;
        this.userName=userName;
        this.email=email;
    }

    public Order checkOut(Cart cart, Order order){
        //Order order = new Order(cart);
        order.setOrderCreated(true);
        order.notifyObservers();
        return order;
    }
}
