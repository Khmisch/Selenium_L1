package cydeo.test.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to "https://practice.cydeo.com/"
        driver.get("https://google.com/");

        // 3. Write "apple" in search box
        // 4. Click google search button
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        //WebElement searchButton = driver.findElement(By.name("btnK"));

        // 5. Verify title Expected: Title should start with "apple" word
        String expectedTitle = "apple";                                     // comes from requirement
        String actualTitle = driver.getTitle();                             // comes from browser
        System.out.println(actualTitle.startsWith(expectedTitle));

        driver.close();
    }
}