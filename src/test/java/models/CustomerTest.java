package models;

import hello.models.Cart;
import hello.models.Customer;
import hello.models.Order;
import hello.models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by chanduk on 13/05/15.
 */
public class CustomerTest {
    Customer customer;
    Cart cart;
    @Before
    public void setUp(){
        customer = new Customer(101,"Jayanta","awakenindian20@gmail.com");
        cart = new Cart(customer);
    }

    @Test
    public void testCartCheckOut(){
        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        cart.addToCart(product1);
        cart.addToCart(product2);
        Order order = new Order(cart);
        customer.checkOut(cart, order);
        Assert.assertNotNull(order);
    }
}
