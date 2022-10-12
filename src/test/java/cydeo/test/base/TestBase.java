package cydeo.test.base;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDownMethod() {
        //  Close driver
        //driver.close();
        driver.quit();
    }

}
