package com.levyvy.Bai22_23_HamChung_WebUI.testcases;

import com.levyvy.Bai22_23_HamChung_WebUI.pages.DashboardPage;
import com.levyvy.Bai22_23_HamChung_WebUI.pages.LoginPage;
import com.levyvy.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckDashboardTotal(){
        loginPage = new LoginPage(driver);

        //loginPage.loginCRM();

        //dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
    }

}