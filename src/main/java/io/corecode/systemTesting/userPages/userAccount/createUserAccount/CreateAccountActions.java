package io.corecode.systemTesting.userPages.userAccount.createUserAccount;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountActions extends CreateAccountElements {

    public CreateAccountActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeUserName(String text){
        userName.sendKeys(text);
    }


    public void writePassword(String text){
        password.sendKeys(text);
    }

    public void clickSubmitCreateAccount(){
        wait.until(ExpectedConditions.visibilityOf(this.submitCreateAccount));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",this.submitCreateAccount);
        //submitCreateAccount.submit();
    }

    public String getMessage(){
        return message.getText();
    }
}
