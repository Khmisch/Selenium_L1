package cydeo.test.day4;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Xpath_CssSelector {
    public static void main(String[] args) {
        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2. Go to "https://practice.cydeo.com/forgot_password"
        driver.get("https://practice.cydeo.com/forgot_password");

        // 3. Locate all web elements on the page using xpath and css

//      a. "Home" link
        WebElement homeLink1 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink3 = driver.findElement(By.xpath("//a[@class='nav-link']"));

//      b. "Forgot password" header
        WebElement header1 = driver.findElement(By.cssSelector("div.example>h2"));
        WebElement header2 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        /*      "//h2[.='Forgot Password']" , "(//*[.='Forgot Password'])[2]" , "//div[@class='example']/h2"                  */
        WebElement header3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

//      c. "E-mail" text
        WebElement emailText1 = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailText2 = driver.findElement(By.xpath("//label[contains(@for,'email')]"));

//      d. E-mail input box
        WebElement emailBox = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

//      e. "Retrieve password" button
        WebElement passwordButton = driver.findElement(By.cssSelector("button[id='form_submit']>i"));

//      f. "Powered by CYDEO" text
        WebElement poweredText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        // 4. Verify all web elements are displayed
        System.out.println("homeLink.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header.isDisplayed() = " + header1.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText1.isDisplayed());
        System.out.println("emailBox.isDisplayed() = " + emailBox.isDisplayed());
        System.out.println("passwordButton.isDisplayed() = " + passwordButton.isDisplayed());
        System.out.println("poweredText.isDisplayed() = " + poweredText.isDisplayed());

        // 5. close the driver
        driver.close();

    }
}
