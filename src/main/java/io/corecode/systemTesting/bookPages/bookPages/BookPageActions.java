package io.corecode.systemTesting.bookPages.bookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class BookPageActions extends BookPageElements {

    public BookPageActions(WebDriver driver, Wait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);

    }
    
    public void  clickCreateButton(){
        createBookButton.click();
    }

    public String getMessage(){
        return message.getText();
    }

    public void clickDeleteLink(){
        deleteLinks.get(deleteLinks.size()-1).click();
    }

    public void clickUpdateLink(){
        updateLinks.get(updateLinks.size()-1).click();
    }
}
