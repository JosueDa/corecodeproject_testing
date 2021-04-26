package io.corecode.systemTesting.adminPage.publisherPages.updatePublisher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class UpdatePublisherElements {

    WebDriver driver;
    Wait wait;

    @FindBy(id = "submitUpdatePublisher")
    WebElement submitUpdatePublisher;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "message")
    WebElement message;
}
