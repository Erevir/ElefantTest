package PageFactory.PagesFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ParfumesPage {
    WebDriver driver;
    public ParfumesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Parfumuri & Cosmetice')]")
    private WebElement parfume_section;

    public ParfumeCosmeticsPage hoverOnMenParfumesButton(){
       parfume_section.click();
        return new ParfumeCosmeticsPage(driver);

    }
}
