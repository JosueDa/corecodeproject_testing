package io.corecode.systemTesting.writerPages.updateWriterPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditWriterPageActions extends EditWriterPageElements{
    private WebDriver driver;
    private WebDriverWait wait;
    public EditWriterPageActions(WebDriver driver,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }
    public String getMessage(){
        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.visibilityOf(this.message));
        return this.message.getText();
    }
    public void enterName(String name){
        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        wait.until(ExpectedConditions.visibilityOf(this.name));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].value='"+name+"';", this.name);
    }
    public void submit(){
        //new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.id("submitUpdateWriter")));
        wait.until(ExpectedConditions.visibilityOf(this.submit));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("arguments[0].click();", this.submit);
    }
}
