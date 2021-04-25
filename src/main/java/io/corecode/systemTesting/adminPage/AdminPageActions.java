package io.corecode.systemTesting.adminPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPageActions extends AdminPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminPageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public String getMessage() {
        return this.message.getText();
    }

    public void clickManageWriters(){
        this.manageWriters.click();
    }

    public void clickManageBooks(){
        this.manageBooks.click();
    }

    public void clickManageReviews(){
        this.manageReviews.click();
    }



}
