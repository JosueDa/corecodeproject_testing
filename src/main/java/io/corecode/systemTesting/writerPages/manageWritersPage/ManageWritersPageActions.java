package io.corecode.systemTesting.writerPages.manageWritersPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageWritersPageActions extends ManageWritersPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public ManageWritersPageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    public void clickCreateWriter(){
        this.createWriter.click();
    }

    public void clickLastEditLink(){
        wait.until(ExpectedConditions.visibilityOfAllElements(this.editLinks));
        WebElement lastLink = this.editLinks.get(this.editLinks.size()-1);
        wait.until(ExpectedConditions.elementToBeClickable(lastLink));
        lastLink.click();
    }

    public void clickLastDeleteLink(){
        this.deleteLinks.get(this.deleteLinks.size()-1).click();
    }

    public String getMessage(){
        wait.until(ExpectedConditions.visibilityOf(this.message));
        return this.message.getText();
    }

}
