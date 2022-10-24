package cydeo.test.day11;

import com.github.javafaker.Faker;
import cydeo.test.day10.Driver;
import cydeo.test.day9.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_JavaFakerPractice {
    @Test
    public void registration_form() {
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("reg.url"));

        Faker faker = new Faker();

        // 3. Enter first name
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        // 4. Enter last name
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        // 5. Enter username
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().username().replace(".", ""));

        // 6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        // 7. Enter password
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        // 8. Enter phone number
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));

        // 9. Select a gender from radio buttons
        List<WebElement> radioButtons = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
        radioButtons.get(faker.number().numberBetween(1, 3)).click();

        // 10. Enter date of birth
        WebElement birthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys(faker.numerify("12/12/2012"));

        // 11. Select Department/Office
        WebElement department = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(department);
        select.selectByIndex(faker.number().numberBetween(1, 9));

        // 12. Select Job Title
        WebElement jobTitle = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        Select select1 = new Select(jobTitle);
        select1.selectByIndex(faker.number().numberBetween(1, 8));

        // 13. Select programming language from checkboxes
        List<WebElement> checkBoxes = Driver.getDriver().findElements(By.xpath("//input[@class='form-check-input']"));
        checkBoxes.get(faker.number().numberBetween(1, 3)).click();

        // 14. Click to sign up button wooden_spoon
        WebElement btnSignUp = Driver.getDriver().findElement(By.id("wooden_spoon"));
        btnSignUp.click();

        // 15. Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement message = Driver.getDriver().findElement(By.tagName("p"));
        Assert.assertEquals(message.getText(), "You've successfully completed registration!");

        // 16. Close driver
        Driver.closeDriver();
    }
}
