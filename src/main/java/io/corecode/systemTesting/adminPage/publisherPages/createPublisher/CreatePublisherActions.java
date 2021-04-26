package io.corecode.systemTesting.adminPage.publisherPages.createPublisher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePublisherActions  extends CreatePublisherElements{
    public CreatePublisherActions(WebDriver driver, WebDriverWait wait) {
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void writeName(String text){
        wait.until(ExpectedConditions.visibilityOf(this.name));
        name.sendKeys(text);
    }

    public void clickSubmitCreatePublisher(){
        submitCreatePublisher.submit();
    }

    public String getMessage(){
        return message.getText();
    }
}
