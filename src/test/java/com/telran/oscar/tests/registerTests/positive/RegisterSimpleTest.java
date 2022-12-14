package com.telran.oscar.tests.registerTests.positive;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterSimpleTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);

        home.clickOnLoginRegisterLink();
    }

    @Test
    public void registerPositiveTest() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);

        Assert.assertTrue(home.getTextAlertIcon().contains("Thanks for registering!"));
        Assert.assertTrue(home.isLogoutLinkLinkExist());
    }

    @AfterMethod
    public void tearDown() {

        HomePage home = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        home.clickOnAccount();
        profilePage.deleteProfile(UserData.REGISTER_PASSWORD);
    }
}
