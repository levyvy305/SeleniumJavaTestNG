package com.levyvy.Bai10_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoBeforeClassAndMethod extends SetupClass{

    @Test(priority = 1, description = "Test case check blog")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
        Assert.fail();
    }

    @Test(priority = 2, description = "Test case search data on Google")
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).isDisplayed());
    }

}