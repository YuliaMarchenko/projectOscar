package com.telran.oscar.tests;

import com.telran.oscar.pages.BasketPage;
import com.telran.oscar.pages.HomePage;
import data.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginRegisterLink().login(UserData.LOGIN_EMAIL, UserData.LOGIN_PASSWORD);
    }

    @Test
    public void orderPositiveTest() {
        new HomePage(driver).clickOnAllProducts();
        new BasketPage(driver).order();
    }

    @AfterMethod
    public void tearDown() {
        new HomePage(driver).clickOnLogout();
    }
}
