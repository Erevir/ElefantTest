package PageFactory.RegistrationFloW;

import Utils.ProjectMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //Objects
    public ProjectMethods functions=new ProjectMethods(driver);

    //   Click on registration button
    @FindBy(how = How.XPATH, using = "//div[@class='hidden-xs header-account-display']")
    private WebElement registration_button;
    @FindBy(how = How.LINK_TEXT, using = "Client nou ? Creeaza-ti cont acum !")
    private WebElement notLoggedInButton;
    @FindBy(how = How.XPATH, using = "//input[@value='1']")
    private WebElement gender_button;
    @FindBy(how = How.ID, using = "r_first_name")
    private WebElement firstNameField;
    @FindBy(how = How.ID, using = "r_last_name")
    private WebElement lastNameField;
    @FindBy(how = How.ID, using = "r_email")
    private WebElement emailNameField;
    @FindBy(how = How.ID, using = "r_password")
    private WebElement passwordField;
    @FindBy(how = How.ID, using = "r_c_password")
    private WebElement confirmPasswordField;
    @FindBy(how = How.XPATH, using = "//input[@value='ok']")
    private WebElement termBoxField;
    @FindBy(how = How.ID, using = "register_classic")
    private WebElement submit_button;
    @FindBy(how = How.XPATH, using = "//div[@class='col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1']/h3[contains(text(),'Inregistrare reusita')]")
    private WebElement succes_message; ////div[@class='col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1']/h3[contains(text(),'Inregistrare reusita')]

    public RegistrationPage processRegistration(){
        functions.clickWebElement(registration_button);
        functions.clickWebElement(notLoggedInButton);
        functions.clickWebElement(gender_button);
        functions.fillWebElement(firstNameField,"Garibaldi");
        functions.fillWebElement(lastNameField,"Giussi");
        functions.fillWebElement(emailNameField, System.currentTimeMillis()+"wengr@yahoo.com");
        functions.fillWebElement(passwordField,"Steelseries_85#");
        functions.fillWebElement(confirmPasswordField,"Steelseries_85#");
        functions.clickWebElement(termBoxField);
        functions.clickWebElement(submit_button);
        return this;

    }
    public RegistrationPage validateRegistrationMessage(){
        functions.waitExplicit(succes_message,driver);
        String actualSuccesMessage = succes_message.getText();
        String expectedSuccesMessage = "Inregistrare reusita";
        Assert.assertEquals(expectedSuccesMessage, actualSuccesMessage);
        return this;
    }




}
