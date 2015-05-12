package models;

import hello.models.Cart;
import hello.models.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by chanduk on 12/05/15.
 */
public class CartTest {
    @Test
    public void testAddFirstProductToCartShouldCreateCart(){
        Cart cart = new Cart();
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertTrue(products.containsKey(product));
    }

    @Test
    public void testAddSameProductToCartShouldIncrementCount(){
        Cart cart = new Cart();
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.addToCart(product);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertEquals(Integer.valueOf(2), products.get(product));
        Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(products.size()));
    }

    @Test
    public void testUpdateProductQuantityInCart(){
        Cart cart = new Cart();
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.updateProductQuantity(product, 20);
        Map<Product,Integer> products = cart.getProducts();
        Assert.assertEquals(Integer.valueOf(20),products.get(product));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testUpdateProductLessThanZeroQuantityInCart(){
        Cart cart = new Cart();
        Product product = new Product(1,"Test Product", 10);
        cart.addToCart(product);
        cart.updateProductQuantity(product, -1);
    }

    @Test
    public void testRemoveProductFromCartWhichExists(){
        Cart cart = new Cart();
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
    public void testRemoveProductFromCartWhichDoesNotExist(){
        Cart cart = new Cart();
        Product product2 = new Product(2,"Test Product2", 102);
        cart.addToCart(new Product(1, "Test Product 1", 100));
        final boolean isRemoved = cart.removeProduct(product2);
        Assert.assertFalse(isRemoved);
    }
}