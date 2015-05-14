package hello.controllers;

import hello.models.Cart;
import hello.models.Customer;
import hello.models.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
