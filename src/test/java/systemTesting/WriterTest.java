package systemTesting;

import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.adminPage.AdminPageActions;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.writerPages.createWriterPage.CreateWriterPageActions;
import io.corecode.systemTesting.writerPages.manageWritersPage.ManageWritersPageActions;
import io.corecode.systemTesting.writerPages.updateWriterPage.EditWriterPageActions;
import io.corecode.testing.MyConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WriterTest extends InitDriver {
    private LoginPagePageActions loginPageActions;
    private AdminPageActions userPageActions;
    private ManageWritersPageActions manageWritersPageActions;
    private CreateWriterPageActions createWriterPageActions;
    private EditWriterPageActions editWriterPageActions;

    @Test(priority = 100)
    public void createWriter() {
        driver.get(MyConstants.website + "login");
        loginPageActions = new LoginPagePageActions(driver, wait);
        loginPageActions.loginUser("admin", "admin");
        userPageActions = new AdminPageActions(driver, wait);
        userPageActions.clickManageWriters();
        manageWritersPageActions = new ManageWritersPageActions(driver, wait);
        manageWritersPageActions.clickCreateWriter();
        createWriterPageActions = new CreateWriterPageActions(driver, wait);
        createWriterPageActions.enterWriterName("test qa");
        createWriterPageActions.clickSubmitCreateWriter();
        String message = createWriterPageActions.getMessage();
        Assert.assertEquals(message, "Writer was successfully created");
    }

    @Test(priority = 200, dependsOnMethods = {"createWriter"})
    public void updateWriter(){
        driver.get(MyConstants.website+"manageWriters");
        manageWritersPageActions = new ManageWritersPageActions(driver, wait);
        manageWritersPageActions.clickLastEditLink();
        editWriterPageActions = new EditWriterPageActions(driver,wait);
        editWriterPageActions.enterName("test qa updated");
        editWriterPageActions.submit();
        String message = editWriterPageActions.getMessage();
        Assert.assertEquals(message,"Writer was updated successfully");
    }

    @Test(priority = 300, dependsOnMethods = {"createWriter"})
    public void deleteWriter() {
        driver.get(MyConstants.website + "manageWriters");
        manageWritersPageActions = new ManageWritersPageActions(driver, wait);
        manageWritersPageActions.clickLastDeleteLink();
        String message = manageWritersPageActions.getMessage();
        Assert.assertEquals(message, "Writer was deleted successfully");
    }
}
