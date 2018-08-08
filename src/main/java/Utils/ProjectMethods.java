package Utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectMethods {

    WebDriver driver;

    //  *******  Constructor  ***********
    public ProjectMethods(WebDriver driver) {
        this.driver = driver;
    }

//  ********  Methods  *********

    //    Click on random web element
    public void clickWebElement(WebElement element) {
        element.click();
    }

    //    validate page
    public void validatePage(String expected, WebDriver driver) {
        if (!(expected.isEmpty())) {
            String actual = driver.getTitle();
            Assert.assertEquals(expected, actual);
        }
    }

    //    Fill a WebElement a value
    public void fillWebElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    //    Select by text
    public void selectByText(WebElement element, String text) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(text);
    }

    //    Select by value
    public void selectByValue(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    //    Hover a WebElement
    public void hoverWebElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    //    Wait explicit
    public void waitExplicit(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    public void acceptAlert() {
        String text = "";
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException e) {
            ;
        } catch (WebDriverException e) {

        }
    }

    public void dismissAlert() {
        String text = "";
        try {
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            alert.dismiss();
        } catch (NoAlertPresentException e) {

        } catch (WebDriverException e) {

        }
    }

    public void alertButton() {
        WebElement alertButton = driver.findElement(By.xpath("//a[contains(text(),'Am inteles')]"));
        alertButton.click();
        alertButton.sendKeys(Keys.ENTER);
        driver.switchTo().alert().accept();
    }
}
