package hello.models;

import java.util.Map;

/**
 * Created by chanduk on 13/05/15.
 */
public class Order {
    private Cart cart;
    private int total=0;
    public Order(Cart cart){
        this.cart = cart;
    }

    public int calculateTotal(){
        Map<Product,Integer> products = cart.getProducts();

        for(Map.Entry<Product,Integer> product : products.entrySet()) {
            int qunatity = product.getValue();
            Product currentProduct = product.getKey();
            int price = currentProduct.getProductPrice();
            this.total = this.total + (qunatity * price);
        }
        return this.total;
    }

    public boolean sendMail() {

        User user = cart.getUser();
        String email = user.getEmail();
        if(email!=null)
            return true;
        return false;
    }
}
