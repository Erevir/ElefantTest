package PageFactory.PagesFlow;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
    WebDriver driver;

    public MyCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='main_comanda']/div/div/div/div/div/a[contains(text(),'Apa de toaleta One Shock, 200 ml, Pentru Barbat')]")
    private WebElement choosenProduct;
    @FindBy(how = How.XPATH, using = "//div[@class='header-cart-icon']")
    private WebElement cart_button;

    public MyCartPage clickCartButton() {
        cart_button.click();
        return this;
    }

    public MyCartPage verifyChoosenProduct() {
        Assert.assertTrue(choosenProduct.getText().contains("Apa de toaleta One Shock, 200 ml, Pentru Barbat"));
        return this;
    }
}
