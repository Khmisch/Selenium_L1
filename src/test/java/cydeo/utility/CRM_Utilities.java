package cydeo.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    // Method #1 info:
    // • Name: login_crm()
    // • Return type: void
    // • Arg1: WebDriver
    public static void login_crm(WebDriver driver){
//      3. Enter valid username: "hr2@cydeo.com"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='email']"));
        inputUsername.sendKeys("");

//      4. Enter valid password: "UserUser"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='pass']"));
        inputPassword.sendKeys("");

//      5. Click to Log In button //input[@class='login-btn']
        WebElement buttonLogIn = driver.findElement(By.xpath("//button[@name='login']"));
        buttonLogIn.click();
    }

    // Method #2 info:
    // • Name: login_crm()
    // • Return type: void
    // • Arg1: WebDriver
    // • Arg2: String username
    // • Arg3: String password
    public static void login_crm(WebDriver driver, String username, String password){
//      3. Enter valid username: "hr2@cydeo.com"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='email']"));
        inputUsername.sendKeys(username);

//      4. Enter valid password: "UserUser"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='pass']"));
        inputPassword.sendKeys(password);

//      5. Click to Log In button //input[@class='login-btn']
        WebElement buttonLogIn = driver.findElement(By.xpath("//button[@name='login']"));
        buttonLogIn.click();
    }

}
