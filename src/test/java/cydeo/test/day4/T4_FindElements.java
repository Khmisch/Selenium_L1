package cydeo.test.day4;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_FindElements {
    public static void main(String[] args) {
        // 1. Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // 2. Go to "https://practice.cydeo.com/forgot_password"
        driver.get("https://practice.cydeo.com/abtest");

        // 3. Locate all links on the page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        // 4. Print out the number of the links on the page
        System.out.println("allLinks.size() = " + allLinks.size());

        // 5. Print out the texts of the links
        for (WebElement link : allLinks) {
            System.out.println("link.getText() = " + link.getText());
        }

        // 6. Print out the href attribute values of the links
        for (WebElement link : allLinks) {
            System.out.println("link.getAttribute(\"href\") = " + link.getAttribute("href"));
        }

        // 7. close the driver
        driver.close();
    }
}
