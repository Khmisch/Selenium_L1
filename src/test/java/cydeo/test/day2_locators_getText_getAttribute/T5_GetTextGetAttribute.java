package cydeo.test.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_GetTextGetAttribute {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to "https://practice.cydeo.com/registration_form"
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify header text is as expected: Registration form
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeader = "Registration form";
        String actualHeader = headerText.getText();

        System.out.println("Verify header text is as expected " + actualHeader.contains(expectedHeader));

        // 4. Locate "First name" input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        // 5. Verify placeholder attribute's value is as expected: first name
        String expectedPlaceholder = "first name";
        String actualPlaceholder = firstNameInput.getAttribute("placeholder");

        System.out.println("Verify placeholder attribute's value is as expected = " + actualPlaceholder.equals(expectedPlaceholder));

        driver.close();

    }
}
