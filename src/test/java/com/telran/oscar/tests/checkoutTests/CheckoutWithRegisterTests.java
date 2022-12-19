package com.telran.oscar.tests.checkoutTests;

import com.telran.oscar.pages.*;
import com.telran.oscar.tests.TestBase;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutWithRegisterTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        HomePage home = new HomePage(driver);
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(driver);

        home.clickOnLoginRegisterLink();
        loginRegisterPage.login(UserData.LOGIN_EMAIL, UserData.LOGIN_PASSWORD);
    }

    @Test
    public void checkoutWithRegisterAddTwoBooksPositiveTest() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        HomePage home = new HomePage(driver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

        sidePanelPage.clickOnBooksLink();
        Double expectedSumProducts = booksPage.getPriceFirstBook() + booksPage.getPriceSecondBook();
        booksPage.addSecondProductInBasket();
        booksPage.addProductAndCheckoutNow();
        checkoutPage.clickOnShipToThisAddress();
        checkoutPage.choosePayment();

        Assert.assertEquals(expectedSumProducts, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedSumProducts, basketPage.getPriceOrderTotalAsDouble());

        checkoutPage.previewOrder();

        Assert.assertEquals(expectedSumProducts, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedSumProducts, basketPage.getPriceOrderTotalAsDouble());

        String numberOrder = checkoutPage.getNumberOfOrder();

        checkoutPage.confirmation();

        Assert.assertTrue(allProductsPage.existHeaderAllProducts());

        home.clickOnAccount();
        orderHistoryPage.clickOnOrderHistory();
        Assert.assertTrue(orderHistoryPage.existNumberOfHistory(numberOrder));
    }

    @AfterMethod
    public void tearDown() {

        HomePage home = new HomePage(driver);

        home.clickOnLogout();
    }
}
