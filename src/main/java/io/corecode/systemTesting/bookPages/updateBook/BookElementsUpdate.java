package io.corecode.systemTesting.bookPages.updateBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class BookElementsUpdate {

    protected WebDriver driver;
    protected Wait wait;

    @FindBy(id = "title")
    WebElement title;

    @FindBy(id = "description")
    WebElement description;

    @FindBy(id = "cover")
    WebElement cover;

    @FindBy(id = "picture")
    WebElement picture;

    @FindBy(id = "submitUpdateBook")
    WebElement submitUpdateBook;

    @FindBy(id = "message")
    WebElement message;

}
