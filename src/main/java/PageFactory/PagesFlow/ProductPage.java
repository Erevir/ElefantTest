package PageFactory.PagesFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a/span[contains(text(),'Adauga in cos')]")
    private WebElement addToCartProduct; //
    public ProductPage addToCart (){
        addToCartProduct.click();
        return this;

    }
}
