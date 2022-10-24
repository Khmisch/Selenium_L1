package cydeo.test.day12;

import cydeo.test.day10.Driver;
import cydeo.utility.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractice {
    @Test
    public void task_4_and_5_test(){
//      1- Open Chrome browser
//      2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        BrowserUtils.sleep(3);
//      3- Scroll down to “Powered by CYDEO”
//      4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.moveToElement(cydeoLink).perform();

//      TC #5: Scroll practice 2
        BrowserUtils.sleep(3);
//      1- Continue from where the Task 4 is left in the same test.
//      2- Scroll back up to “Home” link using PageUP button
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        actions.moveToElement(homeLink).perform();
        //actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

        BrowserUtils.sleep(3);
        // Close driver
        Driver.closeDriver();
    }
}
