package cydeo.test.day6;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_iFramePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void dropDownTask4() {
        // 3. Verify "Your content goes here." text is displayed

        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
        //driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(textArea.isDisplayed());

        // 4. Verify "An iFrame containing the TinyMCE WYSIWYG Editor" text is displayed

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        WebElement textArea2 = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(textArea2.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() {
        //  Close driver
        driver.close();
    }
}
