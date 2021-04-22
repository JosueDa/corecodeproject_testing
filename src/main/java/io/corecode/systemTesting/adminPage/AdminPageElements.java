package io.corecode.systemTesting.adminPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageElements {
    @FindBy(id = "message")
    protected WebElement message;
    @FindBy(id="manageWriters")
    protected WebElement manageWriters;

}