package cydeo.test.day12;

import cydeo.test.day10.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_CircleDragAndDrop {
    @Test
    public void circleDragAndDropTest() throws InterruptedException {
        // Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // Accept Cookies
        WebElement acceptAookies = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        Thread.sleep(3000);
        acceptAookies.click();

        // Drag and drop small circle to big circle
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle).pause(2000).moveToElement(bigCircle).pause(2000).release().perform();

        // Assert text in big circle changed to "You did great!"
        Assert.assertEquals(bigCircle.getText(), "You did great!");

        // Close driver
        Driver.closeDriver();
    }

}
