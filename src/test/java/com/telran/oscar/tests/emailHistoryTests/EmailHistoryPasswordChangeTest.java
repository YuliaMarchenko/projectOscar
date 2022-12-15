package com.telran.oscar.tests.emailHistoryTests;

import com.telran.oscar.pages.*;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailHistoryPasswordChangeTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);
    }

    @Test
    public void checkNotificationWhenPasswordChangePositiveTest(){

        HomePage home = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        EmailHistoryPage emailHistoryPage = new EmailHistoryPage(driver);

        home.clickOnAccount();
        profilePage.changePassword();
        emailHistoryPage.clickOnEmailHistory();

        Assert.assertTrue(emailHistoryPage.existNotificationWhenPasswordChange());
    }

    @AfterMethod
    public void tearDown(){

        HomePage home = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        home.clickOnAccount();
        profilePage.deleteProfile(UserData.REGISTER_WRONG_CONFIRM_PASSWORD);
    }
}
