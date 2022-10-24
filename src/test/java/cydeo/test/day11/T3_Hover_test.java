package cydeo.test.day11;

import cydeo.test.day10.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Hover_test {
    @Test
    public void hover_test() {
        // 1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        // 2. Hover over to first image
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(image1).perform();

        // 3. Assert:
        //  a) “name: user1” is displayed
        //  b) “view profile” is displayed
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement viewProfile1 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']/following-sibling::a"));
        Assert.assertTrue(user1.isDisplayed());
        Assert.assertTrue(viewProfile1.isDisplayed());

        // 4. Hover over to second image
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        action.moveToElement(image2).perform();

        // 5. Assert:
        //  a) “name: user2” is displayed
        //  b) “view profile” is displayed
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement viewProfile2 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']/following-sibling::a"));
        Assert.assertTrue(user2.isDisplayed());
        Assert.assertTrue(viewProfile2.isDisplayed());

        // 6. Hover over to third image
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        action.moveToElement(image3).perform();

        // 7. Confirm:
        //  a) “name: user3” is displayed
        //  b) “view profile” is displayed

        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));
        WebElement viewProfile3 = Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']/following-sibling::a"));
        Assert.assertTrue(user3.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());

        // 8. Close driver
        Driver.closeDriver();
    }

}
