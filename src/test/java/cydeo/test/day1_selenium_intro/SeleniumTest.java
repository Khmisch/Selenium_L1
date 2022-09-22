package cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String args[]) throws InterruptedException {
        //1. Setting up the WebDriverManager
        WebDriverManager.chromedriver().setup();

        //2. Create instance of chromeDriver
        WebDriver driver = new ChromeDriver();

        //3. Test if driver is working
        driver.get("https://www.etsy.com/");

        //making window full screen
        driver.manage().window().maximize();

        //driver.navigate().back() method will take previous page
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        driver.navigate().to("https://www.google.com/");
        String currentTitle = driver.getTitle();
        System.out.println("title = " + currentTitle);


        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        // closes current opened page
//        driver.close();


        // closes all opened pages
        driver.quit();
    }

}
