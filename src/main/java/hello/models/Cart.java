package hello.models;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by chanduk on 12/05/15.
 */
public class Cart {
    private Map<Product,Integer> products;
    private int total;
    private Customer user;
    public Customer getUser() {
        return user;
    }
    public int getTotal(){
        return total;
    }

    public Cart(Customer user) {
        this.user=user;
    }

    public void addToCart(Product product)
    {
        if(products == null){
            products = new LinkedHashMap<>();
        }

        if(isProductExist(product)){
            products.put(product,products.get(product)+1);
        } else{
            products.put(product, 1);
        }

    }

    private boolean isProductExist(Product product) {

        return products.containsKey(product);
    }


    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean removeProduct(Product product)
    {
        if(isProductExist(product)){
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
            products.put(product, quantity);
            return true;
        }
        return false;
    }

    public int calculateTotal(){
        Map<Product,Integer> products = this.getProducts();
        for(Map.Entry<Product,Integer> product : products.entrySet()) {
            int qunatity = product.getValue();
            Product currentProduct = product.getKey();
            int price = currentProduct.getProductPrice();
            this.total = this.total + (qunatity * price);
        }
        return this.total;
    }

    public String toJSON() throws Exception {
        Map<Map<String, Integer>, Integer> cartMap = new HashMap<>();
        Map<Product, Integer> products = this.getProducts();

        for (final Map.Entry<Product, Integer> product : products.entrySet()) {
            int qunatity = product.getValue();
            Product currentProduct = product.getKey();
            final int price = currentProduct.getProductPrice();
            cartMap.put(new HashMap<String, Integer>() {{
                put(product.getKey().getProductName(), price);
            }}, qunatity);
        }
       String json =  convertToJson(cartMap);
        return  json;
    }

    public String convertToJson(Map<Map<String, Integer>, Integer> cartMap) throws Exception, JsonMappingException {

        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            //convert map to JSON string
            json = mapper.writeValueAsString(cartMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
