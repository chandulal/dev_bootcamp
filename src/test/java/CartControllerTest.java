import hello.controllers.CartController;
import org.junit.Test;

/**
 * Created by chanduk on 12/05/15.
 */
public class CartControllerTest {
    @Test
    public void testCartStatus() throws Exception
    {
        CartController cartController = new CartController();
        String json = cartController.cartStatus("cart", null);
        System.out.println(json);
    }

}
