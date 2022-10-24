package cydeo.test.pages;

import cydeo.test.day10.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    public LibraryLoginPage(){
        /*
         * PageFactory class is a Selenium class that supports POM.
         * It has method called initElements. Once it's called, it will store all elements specified using @FindBy
         *   annotation with locator, and it will give elements to the classes when they called.
         * .initElements() method accepts 2 arguments
         *  WebDriver instance and Page class instance (this) means current instance of this class
         * */
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement invalidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;

}
