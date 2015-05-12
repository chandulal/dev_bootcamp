package hello.models;

import java.util.*;

/**
 * Created by chanduk on 12/05/15.
 */
public class Cart {
    private Map<Product,Integer> products;

    public void addToCart(Product product)
    {
        if(products == null){
            products = new LinkedHashMap<>();
        }

        if(isProductExist(product)){
            products.put(product,products.get(product)+1);
        }
        else{
            products.put(product,1);
        }

    }

    private boolean isProductExist(Product product) {

        return products.containsKey(product);
    }

    public Map<Product,Integer> getAllProducts()
    {
        return this.products;
    }

    public boolean removeProduct(Product product)
    {
        if(isProductExist(product)) {
            products.remove(product);
            return true;
        }
        return false;
    }
    public boolean updateProductQuantity(Product product, int quantity){

        if(quantity<1){
             throw new IllegalArgumentException("quantity must be greater than 0");
        }
        if(isProductExist(product)){
            products.put(product,quantity);
            return true;
        }
        return false;
    }
}
