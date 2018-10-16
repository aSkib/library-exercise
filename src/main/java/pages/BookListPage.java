package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BookListPage extends BasePage {

    public BookListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy (xpath = "/html/body/div/div/div[2]/li")
    List<WebElement> bookList;

    private String bookListURL = "https://raamatukogu.herokuapp.com/catalog/books";

    private int getNumberOfBooks(){
        return bookList.size();
    }

    public void goToBookList(){
        driver.get(bookListURL);
    }

    public boolean isBookInTheList(String createdBookUrl){
        boolean result = false;
        List<WebElement> links = new ArrayList<WebElement>();
        int max = getNumberOfBooks();

        //Could not find a way to get URLs from bookList so decided to iterate though the list (found similar solution online)
        for (int i = 1; i <= max ; i++) {
            links.add(driver.findElement(By.xpath("/html/body/div/div/div[2]/li["+i+"]/a")));
        }
        //In theory, book's URL should be a unique identifier, so it would be better to verify book's presence in the list by URL
        for (WebElement link : links){
            if (link.getAttribute("href").equalsIgnoreCase(createdBookUrl)){
                result = true;
            }
        }
        return result;
    }

}
