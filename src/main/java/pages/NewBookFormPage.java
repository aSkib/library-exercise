package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewBookFormPage extends BasePage {

    public NewBookFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy (xpath = "//*[@id=\"title\"]")
    WebElement bookTitle;

    @FindBy(xpath = "//*[@id=\"author\"]")
    WebElement bookAuthor;

    @FindBy(xpath = "//*[@id=\"summary\"]")
    WebElement bookSummary;

    @FindBy(xpath = "//*[@id=\"isbn\"]")
    WebElement bookIsbn;

    @FindBy(xpath = "//*[@id=\"5b6714c93809970014e31c9a\"]")
    WebElement checkBoxFiction;

    @FindBy(xpath = "/html/body/div/div/div[2]/form/button")
    WebElement submitButton;

    private String createBookURL = "https://raamatukogu.herokuapp.com/catalog/book/create";

    public void goToCreateBookPage(){
        driver.get(createBookURL);
    }

    public void setBookTitle(String enteredBookTitle){
        this.writeText(bookTitle, enteredBookTitle);
    }

    public void selectAuthor(String authorName){
        this.selectFromDropdownList(bookAuthor, authorName);
    }

    public void setBookSummary(String enteredBookSummary){
        this.writeText(bookSummary, enteredBookSummary);
    }

    public void setBookIsbn(String enteredBookIsbn){
        this.writeText(bookIsbn, enteredBookIsbn);
    }

    public void setAsFiction(){
        this.clickOnElement(checkBoxFiction);
    }

    public void clickOnSubmit(){
        this.clickOnElement(submitButton);
    }

}
