package PageFactory.LoghinFlow;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoghinPage {

    WebDriver driver;

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

    public void login(String username,String password) {
        account_display_button.click();
        logged_in_button.click();
        user_box.sendKeys(username);
        password_box.sendKeys(password);
        submit_button.click();
    }

    public void logout() {
        my_acoount_button.click();
        logout_button.click();
    }

    //  check confirmation submit
    public void validateSubmit() {
        String actualSuccesMessage = succes_message.getText();
        String expectedSuccesMessage = "Garibaldi";
        Assert.assertEquals(expectedSuccesMessage, actualSuccesMessage);
    }

}

