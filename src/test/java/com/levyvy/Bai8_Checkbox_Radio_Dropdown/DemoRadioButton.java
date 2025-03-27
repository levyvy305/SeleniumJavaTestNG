package com.levyvy.Bai8_Checkbox_Radio_Dropdown;

import com.levyvy.common.LocatorsCRM;
import com.levyvy.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoRadioButton extends BaseTest {
    public static void main(String[] args) {
        DemoRadioButton demo = new DemoRadioButton();
        demo.runTest();
    }

    public void runTest() {
        try {
            createDriver();

            loginCRM();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LocatorsCRM.menuSales))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LocatorsCRM.menuProposals))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LocatorsCRM.buttonNewProposal))).click();

            //Scroll đến element
            WebElement element = driver.findElement(By.xpath("//input[@id='2']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            //Tích chọn Radio Button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Hours']"))).click();

            //Kiểm tra radio button đã được check hay chưa
            boolean isSelected = driver.findElement(By.xpath("//input[@id='2']")).isSelected();
            System.out.println("isSelected (Hours): " + isSelected);

            System.out.println("isSelected (Qty): " + driver.findElement(By.xpath("//input[@id='1']")).isSelected());
            System.out.println("isSelected (Qty/Hours): " + driver.findElement(By.xpath("//input[@id='3']")).isSelected());

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            closeDriver();
        }
    }
}