package systemTesting;

import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.bookPages.bookPages.BookPageActions;
import io.corecode.systemTesting.bookPages.createBook.BookActions;
import io.corecode.systemTesting.bookPages.updateBook.UpdateBookActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.testing.MyConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTest extends InitDriver {

    private AdminPageActions adminActions;
    private LoginPagePageActions loginActions;
    private BookActions bookActions;
    private BookPageActions pageActions;
    private UpdateBookActions updateActions;

    @Test(priority = 100)
    public void createBook() {
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin","admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions= new BookPageActions(driver,wait);
        pageActions.clickCreateButton();
        bookActions = new BookActions(driver,wait);
        bookActions.writeTittle("Book QA");
        bookActions.writeDescription("Create Book for system testing");
        bookActions.writeCover("Cover example");
        bookActions.writePicture("Picture example");
        bookActions.clickSubmitCreate();
        Assert.assertEquals(bookActions.getMessage(),"Book was successfully created");
    }

    @Test(priority = 105)
    public void updateBook() {
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin","admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions= new BookPageActions(driver,wait);
        pageActions.clickUpdateLink();
        updateActions = new UpdateBookActions(driver,wait);
        updateActions.writeTittle("Update QA");
        updateActions.writeDescription("Update Book for system testing");
        updateActions.writeCover("Cover example");
        updateActions.writePicture("Picture example");
        updateActions.clickSubmitUpdate();

    }

    @Test(priority = 110)
    public void deleteBook() {
        driver.get(MyConstants.website + "login");
        loginActions = new LoginPagePageActions(driver, wait);
        loginActions.loginUser("admin","admin");
        adminActions = new AdminPageActions(driver, wait);
        adminActions.clickManageBooks();
        pageActions= new BookPageActions(driver,wait);
        pageActions.clickDeleteLink();
        Assert.assertEquals(pageActions.getMessage(),"Book deleted successfully");
    }
}
