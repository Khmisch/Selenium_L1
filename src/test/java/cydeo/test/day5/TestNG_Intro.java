package cydeo.test.day5;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Intro {

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test one is running");

        String actual = "Apple";
        String expected = "Apple";
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test two is running");

        String actual = "Apple";
        String expected = "Apple";
        Assert.assertTrue(actual.equals(expected));
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running");
    }

}
