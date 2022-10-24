package cydeo.test.day11;

import cydeo.test.day10.Driver;
import cydeo.utility.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {
    @Test
    public void guru99_upload_test() {

        // 1. Go to https://demo.guru99.com/test/upload
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

        // 2. Upload file into Choose File
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\User\\Downloads\\some-file.txt");

        // 3. Click terms of service check box
        WebElement checkBoxTerms = Driver.getDriver().findElement(By.id("terms"));
        checkBoxTerms.click();

        // 4. Click Submit File button submitbutton
        WebElement submit = Driver.getDriver().findElement(By.id("submitbutton"));
        submit.click();

        BrowserUtils.sleep(5);

        // 5. Verify expected message appeared: "1 file has been successfully uploaded"
        WebElement message = Driver.getDriver().findElement(By.id("res"));
        Assert.assertEquals(message.getText(), "1 file\nhas been successfully uploaded.");

        // 6. Close driver
        Driver.closeDriver();
    }
}
