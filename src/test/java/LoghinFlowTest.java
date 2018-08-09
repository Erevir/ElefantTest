import PageFactory.LoghinFlow.*;
import Utils.BaseTest;
import org.junit.Test;

public class LoghinFlowTest extends BaseTest  {

    @Test

    public void testClasicLoghin() throws Exception {

        LoghinPage loghinPage = new LoghinPage(driver);
        String username = BaseTest.getValue("username");
        String password = BaseTest.getValue("password");
        String nopassword= "jahdjkashd";

        loghinPage.login(username, password);
        loghinPage.validateSubmit();
//        Thread.sleep(2500);
        loghinPage.logout();
//        Thread.sleep(1000);

        loghinPage.nologin(username,nopassword);
        loghinPage.validateErrorsSubmit();
        driver.close();
    }
}



