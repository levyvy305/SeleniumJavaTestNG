package com.levyvy.Bai17_PageObjectModel.testcases;

import com.levyvy.Bai17_PageObjectModel.pages.DashboardPage;
import com.levyvy.Bai17_PageObjectModel.pages.LoginPage;
import com.levyvy.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckDashboardTotal(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM();
//===================================================================
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
    }

}