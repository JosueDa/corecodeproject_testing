package io.corecode.systemTesting.adminPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.visibilityOf(this.message));
        return this.message.getText();
    }

    public void clickManageWriters(){
        wait.until(ExpectedConditions.visibilityOf(this.manageWriters));
        this.manageWriters.click();
    }

    public void clickManageBooks(){
        wait.until(ExpectedConditions.visibilityOf(this.manageBooks));
        this.manageBooks.click();
    }

    public void clickManageReviews(){
        wait.until(ExpectedConditions.visibilityOf(this.manageReviews));
        this.manageReviews.click();
    }
    public void clickManageUser(){
        wait.until(ExpectedConditions.visibilityOf(this.manageUsers));
        this.manageUsers.click();
    }
    public void clickManagePublisher(){
        wait.until(ExpectedConditions.visibilityOf(this.managePublishers));
        this.managePublishers.click();
    }
}
