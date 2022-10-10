package cydeo.test.day5;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void googleTitle() {
        String actual = driver.getTitle();
        String expected = "Google";
        Assert.assertEquals(actual, expected, "Title isn't matching");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }
}
