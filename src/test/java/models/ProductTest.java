package models;

import hello.models.Product;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chanduk on 12/05/15.
 */
public class ProductTest {
    @Test
    public void testProductEquals()
    {
        Product iPhoneProduct = new Product(1,"iPhone 6 Plus", 10000);
        Product anotherIPhoneProduct  = new Product(1,"iPhone 6 Plus", 10000);
        Assert.assertTrue(iPhoneProduct.equals(anotherIPhoneProduct));
    }

    @Test
    public void testProductNotEquals()
    {
        Product iPhoneProduct = new Product(1,"iPhone 6 Plus",10000);
        Product nexusPhoneProduct  = new Product(2,"Nexus 4", 20000);
        Assert.assertFalse(iPhoneProduct.equals(nexusPhoneProduct));
    }
}
