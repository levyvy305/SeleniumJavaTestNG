package com.levyvy.Bai22_23_HamChung_WebUI.pages;

import com.levyvy.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khởi tạo giá trị driver cho class WebUI
    }

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
    private By errorMessage1 = By.xpath("(//div[contains(@class, 'alert-danger')])[1]");
    private By errorMessage2 = By.xpath("(//div[contains(@class, 'alert-danger')])[2]");

    public void setEmail(String email) {
        //driver.findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail, email);
    }

    public void setPassword(String password) {
        //driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
        //driver.findElement(buttonLogin).click();
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        //Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        //Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error massage NOT match.");
        WebUI.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
    }

    public void verifyLoginFail(String message) {
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        //Assert.assertEquals(driver.findElement(errorMessage).getText(), message, "Content of error massage NOT match.");
        WebUI.assertEquals(WebUI.getElementText(errorMessage), message, "Content of error massage NOT match.");

    }

    public void verifyLoginFailWithNullFields() {
        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(WebUI.isElementDisplayed(errorMessage1), "Error message 1 NOT displays");
        Assert.assertTrue(WebUI.isElementDisplayed(errorMessage2), "Error message 2 NOT displays");

//        String actualMessage1 = driver.findElement(errorMessage1).getText();
//        String actualMessage2 = driver.findElement(errorMessage1).getText();

        WebUI.assertEquals(WebUI.getElementText(errorMessage1), "The Password field is required.", "Content of error massage 1 NOT match.");
        WebUI.assertEquals(WebUI.getElementText(errorMessage2), "The Email Address field is required.", "Content of error massage 2 NOT match.");

    }

    public void verifyLoginFailWithNullFields_ArrayList(int totalNullFields) {

        WebUI.assertNotContains(WebUI.getCurrentUrl(), "authentication", "FAIL. Vẫn đang ở trang Login");

        List<String> messageString = new ArrayList<>();
        messageString.add("The Password field is required.");
        messageString.add("The Email Address field is required.");

        boolean check = false;

        for (int i = 1; i <= totalNullFields; i++) {
            Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class, 'alert-danger')])[" + i + "]")).isDisplayed(), "Error message " + i + " NOT displays");

            for (int j = 0; j < messageString.size(); j++) {
                if (WebUI.getElementText(By.xpath("(//div[contains(@class, 'alert-danger')])[" + i + "]")).equals(messageString.get(j))) {
                    check = true;
                    break;
                }
            }
            Assert.assertTrue(check, "The content of error message " + i + " not match.");
        }

    }

    public void loginCRM(String email, String password) {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
    }

    public DashboardPage loginCRM() {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        verifyLoginSuccess();
        return new DashboardPage(driver);
    }

}
