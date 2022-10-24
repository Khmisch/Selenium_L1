package cydeo.utility;

import cydeo.test.day10.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BrowserUtils {
    //Methods are static, Because we do not want to create an object to call those methods.
    //We just want to call those methods with class name. That is why they are static type

    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3)
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

    /*
    Method info:
    • Name: verifyTitle()
    • Return type: void
    • Arg1: WebDriver
    • Arg2: String expectedTitle
    public static void verifyTitle()
    BrowserUtils.verifyTitle(driver, "Google");
    */
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
