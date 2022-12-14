package com.telran.oscar.tests.loginTests.negative;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWithInvalidPassword extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);
        home.clickOnLogout().clickOnLoginRegisterLink();
    }

    @Test
    public void loginNegativeTest() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        loginRegisterPage.login(UserData.REGISTER_EMAIL, UserData.REGISTER_WRONG_CONFIRM_PASSWORD);

        Assert.assertTrue(home.isLoginRegisterLinkLinkExist());
    }

    @AfterMethod
    public void tearDown(){
        HomePage home = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        loginRegisterPage.login(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD);
        home.clickOnAccount();
        profilePage.deleteProfile(UserData.REGISTER_PASSWORD);
    }
}
