package PageFactory.UserCartFlow;

import PageFactory.LoghinFlow.LoghinPage;
import Utils.ProjectMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage  {

    WebDriver driver;
    public ProjectMethods functions = new ProjectMethods(driver);

    LoghinPage loghinPage = new LoghinPage(driver);

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='header-cart-icon']")
    private WebElement cart_button;
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13']/a[contains(text(),'modifica')]")//div[@id='more_1994648_13']/a[contains(text(),'modifica')]
    private WebElement modifica_button;
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13_actions']/div/a/span[@class='fa fa-plus-circle']")
    private WebElement plus_button;
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13_actions']/div/a/span[@class='fa fa-minus-circle']")
    private WebElement minus_button;
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13_actions']/div/a[contains(text(),'salveaza')]")
    private WebElement save_button;
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13_actions']/div/a[contains(text(),'anuleaza')]")
    private WebElement anulation_button;
    @FindBy(how = How.XPATH, using = "//a[@id='1994648']")
    private WebElement delete_product_button;
    //div[@id='more_1981989_13']/div/span[contains(text(),'buc')]
    @FindBy(how = How.XPATH, using = "//div[@id='more_1994648_13']/div/span[contains(text(),'buc')]")
    private WebElement quantity_product_field;

    public void clickCartButton() {
        functions.clickWebElement(cart_button);
    }

    public void modifyProductFromCart() {
        functions.clickWebElement(modifica_button);
    }

    public void addProductFromCart() {
        functions.clickWebElement(plus_button);
    }

    public void minusProductFromCart() {
        functions.clickWebElement(minus_button);
    }

    public void saveProductFromCart() {
        functions.clickWebElement(save_button);
    }

    public void anulationProductFromCart() {
        functions.clickWebElement(anulation_button);
    }

    public CartPage deleteProductFromCart() {
        functions.clickWebElement(delete_product_button);
        return this;
    }

    public CartPage verifyProductOnCart() {
        functions.waitExplicit(quantity_product_field,driver);
        String actualNrOfProduct = quantity_product_field.getText();
        String expectedNrOfProduct = "1 buc";
        Assert.assertEquals(expectedNrOfProduct, actualNrOfProduct);
        return this;
    }

    public CartPage regUser(){
        loghinPage.login("username", "password");
        return this;
    }
}
