package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatedBookPage extends BasePage{

    public CreatedBookPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/h1")
    WebElement bookTitle;

    @FindBy(xpath = "/html/body/div/div/div[2]/p[1]/a")
    WebElement bookAuthor;

    @FindBy(xpath = "/html/body/div/div/div[2]/p[2]/strong")
    WebElement bookSummary;

    @FindBy(xpath = "/html/body/div/div/div[2]/p[3]/strong")
    WebElement bookIsbn;

    @FindBy(xpath = "/html/body/div/div/div[2]/p[4]/a")
    WebElement bookGenre;

    @FindBy(xpath = "/html/body/div/div/div[2]/p[5]/a")
    WebElement deleteButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/form/button")
    WebElement deleteConfirmButton;

    public boolean isDeleteButtonDisplayed(){
        return this.deleteButton.isDisplayed();
    }

    public void deleteBook(){
        this.deleteButton.click();
        this.deleteConfirmButton.click();
    }

    public String getCreatedBookURL(){
       return this.driver.getCurrentUrl();
    }

    public boolean containsTitle(String testBookTitle){
        return this.containsText(bookTitle, testBookTitle);
    }

    public boolean containsAuthor(String testBookAuthor){
        return this.containsText(bookAuthor, testBookAuthor);
    }

    public boolean containsGenre(String testBookGenre){
        return this.containsText(bookGenre, testBookGenre);
    }

}
