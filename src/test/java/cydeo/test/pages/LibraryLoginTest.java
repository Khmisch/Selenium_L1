package cydeo.test.pages;

import cydeo.test.day10.Driver;
import cydeo.test.day9.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LibraryLoginTest {

    private LibraryLoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        // 1- Open a Chrome browser
        // 2- Go to: https://library1.cydeo.com/
        loginPage = new LibraryLoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Test
    public void required_field_error_message_test(){
        // 3- Do not enter any information
        // 4- Click to “Sign in” button
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.submitButton.click();

        // 5- Verify expected error is displayed: "This field is required."
        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());

        // Close driver
        Driver.getDriver().quit();
    }

    @Test
    public void invalid_email_error_message_test(){

        // 3- Enter invalid email
        loginPage.inputUsername.sendKeys("abcdefgh");

        // 4- Click to “Sign in” button
        loginPage.submitButton.click();

        // 5- Verify expected error is displayed: "This field is required."
        Assert.assertTrue(loginPage.invalidEmailErrorMessage.isDisplayed());

    }

    @Test
    public void library_negative_login_test(){

        // 3- Enter wrong email or password
        loginPage.inputUsername.sendKeys("wrong@email.com");
        loginPage.inputPassword.sendKeys("password");

        // 4- Click to “Sign in” button
        loginPage.submitButton.click();

        // 5- Verify expected error is displayed: "This field is required."
        Assert.assertTrue(loginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }

    @Test
    public void library_positive_login_test(){

        // 3- Enter wrong email or password
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        // 4- Click to “Sign in” button
        loginPage.submitButton.click();

        // 5- Verify expected error is displayed: "This field is required."
        Assert.assertTrue(loginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        // Close driver
        Driver.closeDriver();
    }
}
