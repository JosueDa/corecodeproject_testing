package io.corecode.systemTesting.adminPage.bookPages.bookPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookPageActions extends BookPageElements {

    public BookPageActions(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);

    }
    
    public void  clickCreateButton(){
        createBookButton.click();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.visibilityOf(this.message));
        return message.getText();
    }

    public void clickDeleteLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.deleteLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",deleteLinks.get(deleteLinks.size()-1));
        //deleteLinks.get(deleteLinks.size()-1).click();
    }

    public void clickUpdateLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.updateLinks));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",updateLinks.get(updateLinks.size()-1));
        //updateLinks.get(updateLinks.size()-1).click();
    }
}
