package com.telran.oscar.tests.emailHistoryTests;

import com.telran.oscar.pages.EmailHistoryPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginRegisterPage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class EmailHistoryWhenRegisterTest extends TestBase {

    @Test
    public void checkNotificationWhenRegisterPositiveTest(){

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);
        EmailHistoryPage emailHistoryPage = new EmailHistoryPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.register(UserData.REGISTER_EMAIL, UserData.REGISTER_PASSWORD, UserData.REGISTER_CONFIRM_PASSWORD);
        home.clickOnAccount();
        emailHistoryPage.clickOnEmailHistory();

        Assert.assertTrue(emailHistoryPage.existNotificationWhenRegister());
    }

    @AfterMethod
    public void tearDown(){

        ProfilePage profilePage = new ProfilePage(driver);

        profilePage.clickOnProfileLink();
        profilePage.deleteProfile(UserData.REGISTER_PASSWORD);
    }

}
