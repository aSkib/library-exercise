package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void writeText (WebElement webElement, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);
    }

    public void selectFromDropdownList(WebElement listElement, String selectedOptionName){
        Select dropdown = new Select (wait.until(ExpectedConditions.visibilityOf(listElement)));
        dropdown.selectByVisibleText(selectedOptionName);
    }

    public void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean containsText(WebElement element, String testText){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText().contains(testText);
    }

}
