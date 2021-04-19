package systemTesting;

import io.corecode.systemTesting.InitDriver;
import io.corecode.systemTesting.loginPage.LoginPagePageActions;
import io.corecode.systemTesting.userPage.UserPageActions;
import io.corecode.testing.MyConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends InitDriver {
    private LoginPagePageActions loginPageActions;
    private UserPageActions userPageActions;

    @Test
    public void loginUser() {
        driver.get(MyConstants.website + "login");
        loginPageActions = new LoginPagePageActions(driver, wait);
        loginPageActions.loginUser("user","user");
        userPageActions = new UserPageActions(driver,wait);
        Assert.assertEquals(userPageActions.getMessage(),"User logged in successfully");
    }

}
