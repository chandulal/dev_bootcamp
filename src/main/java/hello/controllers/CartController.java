package hello.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import hello.models.Cart;
import hello.models.Customer;
import hello.models.Product;
import hello.web.view.View;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chanduk on 12/05/15.
 */
@RestController
public class CartController {
    @RequestMapping("/cart")
    public String cartStatus(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/viewCart")
    public Cart viewCart(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception{
        Customer customer = new Customer(110, "Test", "test@abc.com");
        Product product1 = new Product(1,"IPhone4", 10000);
        Product product2 = new Product(2,"Nokia6345", 2044);
        Cart cart = new Cart(customer);
        cart.addToCart(product1);
        cart.addToCart(product2);
        cart.calculateTotal();
        //model.addAttribute("name",cart.toJSON());
        //return "viewcart";
        return cart;
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @JsonView(View.ProductListing.class)
    public String create(@RequestBody Product product) {
        System.out.println(product);
        product.saveIt();
        return "product added with id "+ product.getProductId();
    }

   /* @RequestMapping(value = "/products", method = RequestMethod.GET)
    @JsonView(View.ProductListing.class)
    public List<Product> get() {
        return Product.REPO.all();
    }
    */
   @RequestMapping("/products")
   public  List<Product> get(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception {
       List<Product> list=Product.REPO.all();
       model.addAttribute("products", list.get(0));
       return list;
   }
}
