package cydeo.test.day10;

import cydeo.test.day9.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
     * Making our driver "driver" instance private, so that it is not reachable from outside the class
     * We make it static, because we want it to run before anything else, also we will use it in static method
     * */
    private static WebDriver driver;

    /*
     * Creating a private constructor, so we are closing access to the object this class from outside any class
     * */
    private Driver() {
    }

    /*
     * Create re-usable utility method which will return some driver instance when we call it.
     * */
    public static WebDriver getDriver() {
        if (driver == null) { // if driver/browser was never opened
            String browserType = ConfigurationReader.getProperty("browser");

            /*
             * Depending on the browserType our switch statement will determine to open specific type of browser/driver
             * */
            switch (browserType) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        /*
         * Some driver instance will be returned every time we call Driver.getDriver() method
         * */
        return driver;
    }
    public static void closeDriver(){
        driver.close();
    }
}
