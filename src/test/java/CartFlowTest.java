import PageFactory.LoghinFlow.LoghinPage;
import PageFactory.UserCartFlow.CartPage;
import Utils.BaseTest;
import org.junit.Test;

public class CartFlowTest extends BaseTest {

    @Test

    public void testCartFlow() throws Exception {

        LoghinPage loghinPage = new LoghinPage(driver);
        CartPage cartPage = new CartPage(driver);
        String username = BaseTest.getValue("username");
        String password = BaseTest.getValue("password");

        loghinPage.login(username, password);
        cartPage.clickCartButton();
        cartPage.modifyProductFromCart();
        cartPage.addProductFromCart();
        cartPage.addProductFromCart();
        cartPage.minusProductFromCart();
        cartPage.saveProductFromCart();
//        cartPage.verifyProductOnCart();
        Thread.sleep(1000);
        cartPage.deleteProductFromCart();


    }
}
