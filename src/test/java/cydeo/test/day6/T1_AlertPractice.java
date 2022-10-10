package cydeo.test.day6;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_AlertPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void dropDownTask4() {
        // 3. Click JS Alert button
        WebElement btnJsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        btnJsAlert.click();

        // 4. Click OK button from the alert
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();

        // 5. Verify success text is displayed
        String expected = "You successfully clicked an alert";
        WebElement text = driver.findElement(By.id("result"));
        Assert.assertTrue(text.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() {
        //  Close driver
        driver.close();
    }
}
