package hello.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.models.Cart;
import hello.models.Catalog;
import hello.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by chanduk on 12/05/15.
 */
@Controller
public class CartController {
    @RequestMapping("/cart")
    public String cartStatus(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        //model.addAttribute("name", name);

        Product iPhone6 = new Product(1,"Iphone6",50000);
        Product nokiaClassic = new Product(1,"Nokia Classic",4000);
        Catalog catalog = new Catalog(iPhone6);
        Cart cart = new Cart();
        cart.addToCart(iPhone6);
        cart.addToCart(nokiaClassic);
        return convertToJson(cart.getProducts());
    }
    public String convertToJson(Map<Product, Integer> dataInMap) throws Exception, JsonMappingException {

        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            //convert map to JSON string
            json = mapper.writeValueAsString(dataInMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }

}
