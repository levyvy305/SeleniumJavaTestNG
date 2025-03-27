package com.levyvy.Bai18_PageFactory.testcases;

import com.levyvy.Bai18_PageFactory.pages.DashboardPage;
import com.levyvy.Bai18_PageFactory.pages.LoginPage;
import com.levyvy.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckDashboardTotal() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
    }

    @Test(priority = 2)
    public void testCheckListMenu() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.getListMenu();
    }

}
