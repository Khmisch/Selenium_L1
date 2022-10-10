package cydeo.test.day3_locators_css_selector;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_GetText_GetAttribute {
    public static void main(String[] args) {
        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2. Go to "https://login1_nextbasecrm.com"
        driver.get("https://login1.nextbasecrm.com/");

        // 3. Verify "remember me" label text as expected
        WebElement rememberMeText = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedText = "Remember me on this computer";
        String actualText = rememberMeText.getText();
        System.out.println(expectedText.equals(actualText));

        // 4. Verify forgot password link text is as expected
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        actualText = "FORGOT YOUR PASSWORD?";
        expectedText = forgotPasswordLink.getText();
        System.out.println(expectedText.equals(actualText));

        // 5. Verify forgot password href attribute's value contains  expected
        expectedText = "forgot_password=yes";
        actualText = forgotPasswordLink.getAttribute("href");
        System.out.println(actualText.contains(expectedText));

        // 6. Close the driver
        driver.close();
    }
}
