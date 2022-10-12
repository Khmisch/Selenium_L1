package cydeo.test.day8;

import cydeo.utility.WebDriverFactory;
import cydeo.utility.WebTableUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/web-tables");
    }


    @Test
    public void verifyOrderName(){

        //3. Verify Bob’s name is listed as expected
        String actualText = driver.findElement(By.xpath("//td[.='Bob Martin']")).getText();   //table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']
        String expectedText = "Bob Martin";
        Assert.assertEquals(actualText, expectedText);

        //4. Verify Bob Martin’s order date is as expected
        WebElement orderDate = driver.findElement(By.xpath("//td[.='Bob Martin']/following-sibling::td[3]")); //table[@id='ctl00_MainContent_orderGrid']//td[.='12/31/2021']  //td[.='Bob Martin']/../td[5]
        expectedText = "12/31/2021";
        actualText = orderDate.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void test2(){
        String customerOrderDate = WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println(customerOrderDate);
    }

    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver,"Ned Stark","05/12/2021");
    }

    @AfterMethod
    public void tearDownMethod() {
        //  Close driver
        //driver.close();
        driver.quit();
    }
}
