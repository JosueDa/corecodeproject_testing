package io.corecode.systemTesting.adminPage.bookPages.createBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class BookActions extends BookElements {

    public BookActions(WebDriver driver, Wait wait){
        this.driver=driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);

    }

    public void writeTittle(String text){
        title.sendKeys(text);
    }

    public void writeDescription(String text){
        description.sendKeys(text);
    }

    public void writeCover(String text){
        cover.sendKeys(text);
    }

    public void writePicture(String text){
        picture.sendKeys(text);
    }

    public void clickSubmitCreate(){
        submitCreateBook.submit();
    }

    public String getMessage(){
        return message.getText();
    }
}
