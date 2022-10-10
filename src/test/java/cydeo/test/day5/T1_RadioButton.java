package cydeo.test.day5;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T1_RadioButton {
    public static void main(String[] args) {

        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2. Go to "https://practice.cydeo.com/radio_buttons"
        driver.get("https://practice.cydeo.com/radio_buttons");

        // 3. Click Hockey radio button
        WebElement radioButtonHockey = driver.findElement(By.xpath("//input[@id='hockey']"));
        radioButtonHockey.click();

        // 4. Verify Hockey radio button is selected after clicking
        System.out.println("radioButtonHockey.isSelected() = " + radioButtonHockey.isSelected());

        // 5. Test all sport radio buttons if they are clickable
        List<WebElement> radioButtonsSport = driver.findElements(By.xpath("//input[@name='sport']"));
        for (WebElement radioButtonSport : radioButtonsSport) {
            radioButtonSport.click();
            System.out.println(radioButtonSport.getAttribute("id") + ".isSelected() = " + radioButtonSport.isSelected());
        }

        // 6. Close the driver
        driver.close();
    }
}
