package cydeo.test.day14;

import cydeo.test.day10.Driver;
import cydeo.test.pages.InternetSpeedPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class InternetSpeedTest {
    @Test
    public void internet_speed_test(){
        // 1- Open a Chrome browser
        // 2- Go to: https://www.speedtest.net/
        Driver.getDriver().get("https://www.speedtest.net/");

        // 3- Wait until Results link is displayed
        InternetSpeedPage speedPage = new InternetSpeedPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(50));

        wait.until(ExpectedConditions.visibilityOf(speedPage.resultLink));

        // 4- Click on Go button
        speedPage.buttonGo.click();

        // 5- Wait until gauge-speed-needle displayed
        wait.until(ExpectedConditions.visibilityOf(speedPage.gaugeSpeedNeedle));

        // 6- Wait until gauge-speed-needle disappear
        wait.until(ExpectedConditions.invisibilityOf(speedPage.gaugeSpeedNeedle));

        // 7- Print Download and Upload Speeds
        System.out.println("Upload Speed: "+speedPage.uploadSpeed.getText());
        System.out.println("Download Speed: "+speedPage.downloadSpeed.getText());

        // 8. Close driver
        Driver.closeDriver();
    }

}
