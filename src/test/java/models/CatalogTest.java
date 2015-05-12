package models;

import hello.models.Catalog;
import hello.models.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by chanduk on 12/05/15.
 */
public class CatalogTest {


    @Test
    public void testCreateCatalog(){
        final Product iPhoneProduct = new Product(1,"iPhone 6 Plus", 10000);
        final Catalog catalog = new Catalog(iPhoneProduct);
        final Collection<Product> products = catalog.getProducts();
        Assert.assertTrue(products.contains(iPhoneProduct));
    }

    @Test
    public void testAddProduct() throws Exception {
        final Product iPhoneProduct = new Product(1,"iPhone 6 Plus", 10000);
        final Catalog catalog = new Catalog(iPhoneProduct);
        catalog.addProduct(iPhoneProduct);
        final Collection<Product> products = catalog.getProducts();
        Assert.assertTrue(products.contains(iPhoneProduct));
    }
    @Test
    public void testGetProducts() throws Exception {
        final Product iPhoneProduct = new Product(1,"iPhone 6 Plus", 10000);
        final Product yotto = new Product(2,"yotto c9035", 10000);
        final Catalog catalog = new Catalog(iPhoneProduct);
        catalog.addProduct(yotto);
        final Collection<Product> products = catalog.getProducts();
        Assert.assertTrue(products.contains(iPhoneProduct) && products.contains(yotto));
    }

}
