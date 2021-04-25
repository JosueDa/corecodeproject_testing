package io.corecode.systemTesting.userPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPageActions extends UserPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public UserPageActions(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public String getMessage() {
        return this.message.getText();
    }
    public void clickFirstBookLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.bookLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", this.bookLinks.get(0));
        //this.bookLinks.get(0).click();
    }
    public void clickMyReviews(){
        this.myReviews.click();
    }

}