package cydeo.test.day12;

import cydeo.test.day10.Driver;
import cydeo.utility.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_JavascriptExecutor_Scroll {
    @Test
    public void task7_JavascriptExecutor_Scroll_Test(){
        // 1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //3- Scroll down to “Cydeo” link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        BrowserUtils.sleep(3);

        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);

        BrowserUtils.sleep(3);

        //4- Scroll up to “Home” link
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",homeLink);

        //5- Use below provided JS method only

        //JavaScript's method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them
        //as arguments into executeScript() method

    }

}
