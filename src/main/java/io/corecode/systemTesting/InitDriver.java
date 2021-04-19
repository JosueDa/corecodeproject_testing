package io.corecode.systemTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;


public class InitDriver {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private String chromeDriver = "";


    @BeforeClass(alwaysRun = true)
    public void openDriver(@Optional("chrome") String runOn) {
        initDriver(runOn);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void initDriver(String runOn) {
        try {
            chromeDriver = "drivers/windows/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.merge(caps);
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 15, 100);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Failed to init the browser");
        }
    }


}
