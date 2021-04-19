package io.corecode.systemTesting.userPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPageActions extends UserPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserPageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public String getMessage() {
        return this.message.getText();
    }

}
