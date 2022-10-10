package cydeo.test.day3_locators_css_selector;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_GetText_CssSelector {
    public static void main(String[] args) {

        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2. Go to "https://login1_nextbasecrm.com"
        driver.get("https://login1.nextbasecrm.com/");

        // 3. Verify Login button text is as expected

//        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

//        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

//        WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

//        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));

        WebElement loginButton = driver.findElement(By.cssSelector("input[onclick=\"BX.addClass(this, 'wait');\"]"));

       /* String expectedText = "Log In";
        String actualText = loginButton.getText();
        System.out.println(actualText);*/

        // 4. Close the driver
        driver.close();
    }
}
