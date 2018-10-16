package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BookListPage;
import pages.CreatedBookPage;
import pages.NewBookFormPage;

public class AddBookTests extends BaseTest {
    private NewBookFormPage newBookFormPage = new NewBookFormPage(driver, wait);
    private CreatedBookPage createdBookPage = new CreatedBookPage(driver, wait);
    private BookListPage bookListPage = new BookListPage(driver, wait);

    private String createdBookURL;

    //TODO Create separate class with TEST DATA
    private String bookTitle = "TOP 10 facts you DO NOT need to know";
    private String authorName = "Automated, Testbot";
    private String bookSummary = "This is some static summary";
    private String bookIsbn = "978-0131872486";
    private String bookGenre = "Fiction";


    @Before
    public void addBook(){
        System.out.println("Step 1: Open the 'Create Book' page");
        newBookFormPage.goToCreateBookPage();
        System.out.println("Step 2: Enter predefined Title");
        newBookFormPage.setBookTitle(bookTitle);
        System.out.println("Step 3: Choose Testbot as an Author");
        newBookFormPage.selectAuthor(authorName);
        System.out.println("Step 4: Fill in summary");
        newBookFormPage.setBookSummary(bookSummary);
        System.out.println("Step 5: Fill in ISBN");
        newBookFormPage.setBookIsbn(bookIsbn);
        System.out.println("Step 6: Mark the book as Fiction");
        newBookFormPage.setAsFiction();
        System.out.println("Step 7: Create a book by clicking on the Submit button");
        newBookFormPage.clickOnSubmit();
        //Store created Book URL for reference
        createdBookURL = createdBookPage.getCreatedBookURL();

    }

    @Test
    public void testBookAdded(){
        System.out.println("Checking whether a user is navigated to a Book Page...");
        Assert.assertTrue("Delete button is NOT presented", createdBookPage.isDeleteButtonDisplayed());
    }

    @Test
    public void confirmBookDetails(){
        System.out.println("Checking that title contains given book Title...");
        Assert.assertTrue("Title DOES NOT match", createdBookPage.containsTitle(bookTitle));
        System.out.println("Checking that author contains given book Author name...");
        Assert.assertTrue("Author name DOES NOT match", createdBookPage.containsAuthor(authorName));
        System.out.println("Checking that Genre contains chosen book genre...");
        Assert.assertTrue("Genre name DOES NOT match", createdBookPage.containsGenre(bookGenre));
        //TODO Add checks for Summary and ISBN fields
    }

    @Test
    public void confirmBookIsInCatalogue(){
        System.out.println("Open Book List Page");
        bookListPage.goToBookList();
        Assert.assertTrue("Created Book IS NOT found in the list", bookListPage.isBookInTheList(createdBookURL));
    }

    @After
    public void removeCreatedBook(){
        System.out.println("Clearing the library from test book");
        driver.get(createdBookURL);
        createdBookPage.deleteBook();
        System.out.println("Test book is deleted");
        }
}
