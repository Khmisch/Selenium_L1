package cydeo.test.day5;

import cydeo.utility.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_StaleElementReferenceException {
    public static void main(String[] args) {

        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // 2. Go to "https://practice.cydeo.com/add_remove_elements/"
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        // 3. Click Add Element button
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();

        // 4. Verify "Delete" button is displayed after clicking
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());

        // 5. Click to Delete button
        deleteButton.click();

        // 6. Verify Delete button is eliminated
        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (Exception e){
            System.out.println("Stale element reference: element is not attached to the page document");
        }finally {
            // 7. Close the driver
            driver.close();
        }

    }
}
