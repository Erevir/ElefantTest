import PageFactory.RegistrationFloW.RegistrationPage;
import Utils.BaseTest;
import org.junit.Test;

public class RegistrationFlowTest extends BaseTest {
    @Test
    public void RegTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.processRegistration();
        registrationPage.validateRegistrationMessage();


    }

}


