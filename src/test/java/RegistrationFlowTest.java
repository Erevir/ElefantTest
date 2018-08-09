import PageFactory.RegistrationFlow.RegistrationPage;
import Utils.BaseTest;
import org.junit.Test;

public class RegistrationFlowTest extends BaseTest {
    @Test
    public void RegTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String firstNameField = BaseTest.getValue("firstNameField");
        String lastNameField = BaseTest.getValue("lastNameField");
        String emailNameField = System.currentTimeMillis()+BaseTest.getValue("emailNameField");
        String passwordField = BaseTest.getValue("passwordField");
        String confirmPasswordField = BaseTest.getValue("confirmPasswordField");

        registrationPage.processRegistration(firstNameField,lastNameField, emailNameField,passwordField, confirmPasswordField);
        registrationPage.validateRegistrationMessage();


    }

}


