package cydeo.test.day13;

import cydeo.test.day10.Driver;
import cydeo.test.pages.DynamicallyLoadedPage1;
import cydeo.test.pages.DynamicallyLoadedPage_7;
import jdk.jfr.Timespan;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitPractices {
    @Test
    public void dynamically_loaded_page_elements7_test(){
        // 1- Open a Chrome browser
        // 2- Go to: https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicallyLoadedPage_7 loadedPage7 = new DynamicallyLoadedPage_7();

        // 3. Wait until title is "Dynamic title"
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        // 4. Verify message "Done!" is displayed
        Assert.assertTrue(loadedPage7.doneMessage.isDisplayed());

        // 4. Verify image is displayed
        wait.until(ExpectedConditions.visibilityOf(loadedPage7.image));
        Assert.assertTrue(loadedPage7.image.isDisplayed());

    }

    @Test
    public void dynamically_loaded_page_elements1_test(){
        // 1- Go to: https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicallyLoadedPage1 loadedPage1 = new DynamicallyLoadedPage1();

        // 2. Click to start
        loadedPage1.buttonStart.click();

        // 3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(loadedPage1.loadingBar));

        // 4. Assert username inputBox is displayed
        Assert.assertTrue(loadedPage1.username.isDisplayed());

        // 5. Enter username: "tomsmith"
        loadedPage1.username.sendKeys("");

        // 6. Enter password: "incorrectpassword"
        loadedPage1.password.sendKeys("");

        // 7. Click to Submit button
        loadedPage1.buttonSubmit.click();

        // 8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(loadedPage1.errorMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        // Close driver
        Driver.closeDriver();
    }
}
