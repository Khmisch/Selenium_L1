package cydeo.test.pages;

import cydeo.test.day10.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage1 {
    public DynamicallyLoadedPage1() {
        // this will give access to all object/webElements
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='start']//button")
    public WebElement buttonStart;

    @FindBy(css = "div#loading")
    public WebElement loadingBar;

    @FindBy(css = "#username")
    public WebElement username;

    @FindBy(css = "#pwd")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSubmit;

    @FindBy(xpath = "//div[@id='flash']")
    public WebElement errorMessage;
}
