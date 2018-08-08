import Utils.BaseTest;
import Utils.ProjectMethods;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

public class RegOldTest extends BaseTest {
    //Objects
    public ProjectMethods functions;

    @Before
    public void initiate() {
        functions = new ProjectMethods(driver);
    }

    @Test

    public void test() throws InterruptedException {

       //   Click on registration button
        WebElement registrationButton = driver.findElement(By.xpath("//div[@class='hidden-xs header-account-display']"));
        functions.clickWebElement(registrationButton);

        WebElement notLoggedInButton = driver.findElement(By.linkText("Client nou ? Creeaza-ti cont acum !"));
        functions.clickWebElement(notLoggedInButton);

        // check Gender Status
        driver.findElement(By.xpath("//input[@value='1']")).click();

        // Fill firstName field
        WebElement firstNameField = driver.findElement(By.id("r_first_name"));
        String firstNameValue = "Garibaldi";
        functions.fillWebElement(firstNameField, firstNameValue);

        // Fill lastName field
        WebElement lastNameField = driver.findElement(By.id("r_last_name"));
        String lastNameValue = "Giussi";
        functions.fillWebElement(lastNameField,lastNameValue);

       // check Email
        WebElement checkEmail = driver.findElement(By.id("r_email"));
         String emailValue = System.currentTimeMillis() + "wengr@yahoo.com";
//        String emailValue = "greek#54210@yahoo.com";
        functions.fillWebElement(checkEmail, emailValue);

        // check Password
        WebElement checkPassword = driver.findElement(By.id("r_password"));
        String passValue = "Steelseries_85#";
        functions.fillWebElement(checkPassword,passValue);

        // check confirmPassword
        WebElement checkConfirmPassword = driver.findElement(By.id("r_c_password"));
        String confirmPassValue = "Steelseries_85#";
        functions.fillWebElement(checkConfirmPassword, confirmPassValue);

        //  accept alert
        functions.dismissAlert();

        // check TermsBox
        driver.findElement(By.xpath("//input[@value='ok']")).click();

        // check SubmitClassic
        WebElement submitButton = driver.findElement(By.id("register_classic"));
        functions.clickWebElement(submitButton);

        //  check confirmation submit//
        WebElement succesMessage = driver.findElement(By.xpath("//div[@class='col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1']/h3[contains(text(),'Inregistrare reusita')]"));
//        functions.waitExplicit(succesMessage, driver);
        Thread.sleep(2500);
        String actualSuccesMessage = succesMessage.getText();
        String expectedSuccesMessage = "Inregistrare reusita";
        Assert.assertEquals(expectedSuccesMessage, actualSuccesMessage);


    }
}

