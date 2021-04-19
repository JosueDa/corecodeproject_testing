package io.corecode.systemTesting.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePageActions extends LoginPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPagePageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    private void enterUserName(String username) {
        this.userName.sendKeys(username);
    }

    private void enterPassword(String username) {
        this.password.sendKeys(username);
    }

    private void clickSubmitLogin() {
        this.submitLogin.click();
    }

    public void loginUser(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickSubmitLogin();
    }
}
