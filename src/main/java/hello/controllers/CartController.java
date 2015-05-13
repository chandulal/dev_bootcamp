package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chanduk on 12/05/15.
 */
@Controller
public class CartController {
    @RequestMapping("/cart")
    public String cartStatus(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) throws Exception {
        model.addAttribute("name", name);
        return "greeting";
    }

}
