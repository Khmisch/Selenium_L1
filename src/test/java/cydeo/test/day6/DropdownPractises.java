package cydeo.test.day6;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DropdownPractises {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Setup browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to webpage
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropDownTask4() {
        // 3. Select Illinois using visible text
        WebElement stateDropDown = driver.findElement(By.id("state"));
        Select selectStateDropDown = new Select(stateDropDown);
        selectStateDropDown.selectByVisibleText("Illinois");

        // 4. Select Virginia using value
        selectStateDropDown.selectByValue("VA");

        // 5. Select California using index
        selectStateDropDown.selectByIndex(5);

        // 6. Verify final selected option is California
        String actual = selectStateDropDown.getFirstSelectedOption().getText();
        String expected = "California";

        Assert.assertEquals(actual, expected, "State isn't matching");

        // 7. Get index of the option
        int index = -1;
        for (WebElement option : selectStateDropDown.getOptions()) {
            index++;
            if (Objects.equals(option.getText(), "California")) System.out.println("California = "+index);
        }
        System.out.println("index = " + index);

    }

    @Test
    public void dropDownTask7(){
        WebElement languages = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select selectLanguage = new Select(languages);

        // Select all the options from multiple select dropdown
        // Print out all selected options
        for (WebElement option : selectLanguage.getOptions()) {
            option.click();
            System.out.println(option.getText());
        }

        // Deselect all options
        selectLanguage.deselectAll();
    }

    @AfterMethod
    public void tearDownMethod() {
        // 4. Close driver
        driver.close();
    }
}
