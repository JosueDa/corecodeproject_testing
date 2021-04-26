package io.corecode.systemTesting.adminPage.bookPages.createBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class BookElements {

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

    @FindBy(id = "submitCreateBook")
    WebElement submitCreateBook;

    @FindBy(id = "message")
    WebElement message;

}
