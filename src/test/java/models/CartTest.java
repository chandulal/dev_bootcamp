package models;

import hello.models.Cart;
import hello.models.Order;
import hello.models.Product;
import hello.models.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by chanduk on 12/05/15.
 */
public class CartTest {
    Customer user;
    Cart cart;
    //Customer customer;

    @Before
    public void setUp(){
        user = new Customer(101,"Jayanta","awakenindian20@gmail.com");
        cart = new Cart(user);
    }

    @Test
    public void testAddFirstProductToCartShouldCreateCart(){

        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertTrue(products.containsKey(product));
    }

    @Test
    public void testAddSameProductToCartShouldIncrementCount(){
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.addToCart(product);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertEquals(Integer.valueOf(2), products.get(product));
        Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(products.size()));
    }

    @Test
    public void testUpdateProductQuantityInCart(){
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.updateProductQuantity(product, 20);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertEquals(Integer.valueOf(20), products.get(product));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateProductLessThanZeroQuantityInCart(){
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.updateProductQuantity(product, -1);
    }

    @Test
    public void testRemoveProductFromCartWhichExists(){
        Product product1 = new Product(1,"Test Product1", 101);
        Product product2 = new Product(2,"Test Product2", 102);
        cart.addToCart(product1);
        cart.addToCart(product2);
        final boolean isRemoved = cart.removeProduct(product1);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertFalse(products.containsKey(product1));
        Assert.assertTrue(isRemoved);
    }

    @Test
    public void testRemoveProductFromCartWhichDoesNotExist() {
        Product product2 = new Product(2, "Test Product2", 102);
        cart.addToCart(new Product(1, "Test Product 1", 100));
        final boolean isRemoved = cart.removeProduct(product2);
        Assert.assertFalse(isRemoved);
    }

    @Test
    public void testCalculateTotalAmountForOrder(){
        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        cart.addToCart(product1);
        cart.addToCart(product2);
        Order order = new Order(cart);
        user.checkOut(cart, order);
        int totalAmount = cart.calculateTotal();
        junit.framework.Assert.assertEquals(12044, totalAmount);
    }
}
