package com.telran.oscar.tests.registerTests.negative;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginRegisterPage;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterWrongData extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);

        home.clickOnLoginRegisterLink();
    }

    @Test
    public void registerWithDifferentPasswordAndConfirmPasswordNegativeTest(){

        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_WRONG_CONFIRM_PASSWORD);

        Assert.assertTrue(loginRegisterPage.existErrorRegisterFails());
    }

    @Test
    public void registerWithWrongPasswordNegativeTest(){

        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_WRONG_PASSWORD, UserData.REGISTER_WRONG_PASSWORD);

        Assert.assertTrue(loginRegisterPage.existErrorRegisterFails());
    }

    @Test
    public void registerWithWrongEmailNegativeTest(){

        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);
        HomePage home = new HomePage(driver);

        loginRegisterPage.register(UserData.REGISTER_WRONG_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_PASSWORD);

        Assert.assertTrue(loginRegisterPage.registrationEmailFieldIsEmail());
        Assert.assertTrue(home.isLoginRegisterLinkLinkExist());
    }

}
