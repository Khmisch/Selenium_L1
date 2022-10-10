package cydeo.test.day5;

import cydeo.utility.WebDriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SimpleDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropDown() {
        // 2. Verify Simple Dropdown default selected value is correct
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown = new Select(simpleDropDown);
        String actual = selectSimpleDropDown.getFirstSelectedOption().getText();
        String expected = "Please select an option";

        Assert.assertEquals(actual, expected, "Title isn't matching");

        // 3. Verify State Selection default selected value is correct
        WebElement stateDropDown = driver.findElement(By.id("state"));
        Select selectStateDropDown = new Select(stateDropDown);
        actual = selectStateDropDown.getFirstSelectedOption().getText();
        expected = "Select a State";

        Assert.assertEquals(actual, expected, "Title isn't matching");
    }

    @AfterMethod
    public void tearDownMethod() {
        // 4. Close driver
        driver.close();
    }

}
