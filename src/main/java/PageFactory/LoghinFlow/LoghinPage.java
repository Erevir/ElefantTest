package PageFactory.LoghinFlow;

import Utils.ProjectMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoghinPage {

    WebDriver driver;
    public ProjectMethods functions = new ProjectMethods(driver);

    public LoghinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='hidden-xs header-account-display']")
    private WebElement account_display_button;
    @FindBy(how = How.LINK_TEXT, using = "Intra in cont")
    private WebElement logged_in_button;
    @FindBy(how = How.ID, using = "login_username")
    private WebElement user_box;
    @FindBy(how = How.ID, using = "login_password")
    private WebElement password_box;
    @FindBy(how = How.ID, using = "login_classic")
    private WebElement submit_button;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Garibaldi')]")
    private WebElement succes_message;
    @FindBy(how = How.XPATH, using = "//div[@class='header-account-holder']/div[contains(text(),'Contul')]")
    private WebElement my_acoount_button;
    @FindBy(how = How.ID, using = "logout-button")
    private WebElement logout_button;
    @FindBy(how = How.XPATH, using = "//div[@class='col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 errors']")
    private WebElement unsucces_message;

    public LoghinPage login(String username, String password) {
        functions.clickWebElement(account_display_button);
        functions.clickWebElement(logged_in_button);
        functions.fillWebElement(user_box, username);
        functions.fillWebElement(password_box, password);
        functions.clickWebElement(submit_button);
        return this;
    }

    public LoghinPage nologin(String username, String nopassword) {
        functions.waitExplicit(account_display_button, driver);
        functions.clickWebElement(account_display_button);
        functions.clickWebElement(logged_in_button);
        functions.fillWebElement(user_box, username);
        functions.fillWebElement(password_box, nopassword);
        functions.clickWebElement(submit_button);
        return this;
    }

    public LoghinPage logout() {
        functions.waitExplicit(my_acoount_button, driver);
        functions.clickWebElement(my_acoount_button);
        functions.clickWebElement(logout_button);
        return this;
    }

    //  check confirmation submit
    public LoghinPage validateSubmit() {
        String actualSuccesMessage = succes_message.getText();
        String expectedSuccesMessage = "Garibaldi";
        Assert.assertEquals(expectedSuccesMessage, actualSuccesMessage);
        return this;
    }

    //  check error submit
    public LoghinPage validateErrorsSubmit() {
        String actualSuccesMessage = unsucces_message.getText();
        String expectedSuccesMessage = "Email-ul si/sau parola introduse sunt gresite.";
        Assert.assertEquals(expectedSuccesMessage, actualSuccesMessage);
        return this;
    }
}

