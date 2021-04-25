package io.corecode.systemTesting.manageReviewsPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageReviewsPageActions extends ManageReviewsPageElements{
    private WebDriver driver;
    private WebDriverWait wait;

    public ManageReviewsPageActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public void clickLastDeleteLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.deleteLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.deleteLinks.get(this.deleteLinks.size()-1));
    }

    public String getMessage(){
        return this.message.getText();
    }
}
