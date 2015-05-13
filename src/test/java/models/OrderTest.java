package models;

import hello.models.Cart;
import hello.models.Order;
import hello.models.Product;
import hello.models.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chanduk on 13/05/15.
 */
public class OrderTest {

    User user;
    Cart cart;
    @Before
    public void setUp(){
        user = new User(101,"Jayanta","awakenindian20@gmail.com");
        cart = new Cart(user);
    }

    @Test
    public void testCalculateTotalAmountForOrder(){
        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        cart.addToCart(product1);
        cart.addToCart(product2);
        Order order = cart.checkOut();
        int totalAmount = order.calculateTotal();
        Assert.assertEquals(12044,totalAmount);
    }

    @Test
    public void sendEmail(){
        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        cart.addToCart(product1);
        cart.addToCart(product2);
        Order order = cart.checkOut();
        order.calculateTotal();
        Assert.assertTrue(order.sendMail());
    }
}
