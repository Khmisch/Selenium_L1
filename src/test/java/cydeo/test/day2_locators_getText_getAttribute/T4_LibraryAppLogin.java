package cydeo.test.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryAppLogin {

    public static void main(String[] args) throws InterruptedException {
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to "https://library2.cydeo.com/login.html"
        driver.get("https://library2.cydeo.com/login.html");

        // 3. Enter username: incorrect@gmail.com
        WebElement userNameInput = driver.findElement(By.className("form-control"));
        userNameInput.sendKeys("incorrect@gmail.com");

        // 4. Enter password: "incorrect password"
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        passwordInput.sendKeys("incorrect password");

        // 5. Verify warning message is displayed
        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

        Thread.sleep(2000);

        String expectedTitle = "Sorry, Wrong Email or Password";
        String actualTitle = driver.findElement(By.className("alert-danger")).getText();
        System.out.println(actualTitle.startsWith(expectedTitle));

        driver.close();
    }
}
