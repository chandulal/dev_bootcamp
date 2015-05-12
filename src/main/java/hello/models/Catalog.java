package hello.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chanduk on 12/05/15.
 */
public class Catalog {
    Set<Product> products;

    public Catalog(Product product) {
        products = new HashSet<>();
        products.add(product);
    }
    public Collection<Product> getProducts()
    {
        return this.products;
    }
    public void addProduct(final Product product)
    {
        this.products.add(product);
    }
}
