package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
        webElement.sendKeys(text);
    }

    public void selectFromDropdownList(WebElement listElement, String selectedOptionName){
        Select dropdown = new Select (listElement);
        dropdown.selectByVisibleText(selectedOptionName);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public boolean containsText(WebElement element, String testText){
        return element.getText().contains(testText);
    }

}
