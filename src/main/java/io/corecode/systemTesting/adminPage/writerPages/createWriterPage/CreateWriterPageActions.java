package io.corecode.systemTesting.adminPage.writerPages.createWriterPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWriterPageActions extends CreateWriterPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public CreateWriterPageActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }
    public void enterWriterName(String writerName){
        this.name.sendKeys(writerName);
    }
    public void clickSubmitCreateWriter(){
        this.submitCreateWriter.click();
    }
    public String getMessage() {
        return this.message.getText();
    }
}