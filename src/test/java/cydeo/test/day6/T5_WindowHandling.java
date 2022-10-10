package cydeo.test.day6;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T5_WindowHandling {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void dropDownTask4() {
        // 1. Assert: Title is "Windows"
        Assert.assertEquals(driver.getTitle(), "Windows");

        // 2. Click the link
        WebElement link = driver.findElement(By.xpath("//div[@class='example']/a"));
        link.click();

        // 3. Switch to new window

        //Get handles of the windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Here we will check if child window has other child windows and will fetch the heading of the child window
        for (String childWindow : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }

        // 4. Assert: Title is "New Window"
        Assert.assertEquals(driver.getTitle(), "New Window");

    }

    @AfterMethod
    public void tearDownMethod() {
        //  Close driver
        driver.quit();
    }
}
