package PageFactory.PagesFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ParfumeCosmeticsPage {
    WebDriver driver;

    public ParfumeCosmeticsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Parfumuri pentru barbati')]")
    private WebElement men_parfume_section;

    public MenParfumesProductsPage clickOnMenParfumesButton() {
        men_parfume_section.click();
        return new MenParfumesProductsPage(driver);

    }
}
