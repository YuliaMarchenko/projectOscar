package com.telran.oscar.tests.register.negative;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterExistingUserTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);
        home.clickOnLogout();
    }

    @Test
    public void registerExistingUserNegativeTest() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);

        Assert.assertTrue(loginRegisterPage.existErrorEmailAddress());
    }

    @AfterMethod
    public void tearDown() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginRegisterPage.login(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD);
        home.clickOnAccount();
        profilePage.deleteProfile(UserData.REGISTER_PASSWORD);
    }
}
