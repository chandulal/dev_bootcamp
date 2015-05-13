package models;

import hello.models.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chanduk on 13/05/15.
 */
public class OrderTest {

    Customer user;
    Cart cart;
    @Before
    public void setUp(){
        user = new Customer(101,"Jayanta","awakenindian20@gmail.com");
        cart = new Cart(user);
    }

    @Test
    public void testNotification(){

        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        cart.addToCart(product1);
        cart.addToCart(product2);
        Order order = new Order(cart);

        OrderObserver observer = new OrderObserver();
        order.register(observer);
        observer.setSubject(order);
        user.checkOut(cart, order);


        observer.update();
        order.getEmailDetails(observer);
    }
}
