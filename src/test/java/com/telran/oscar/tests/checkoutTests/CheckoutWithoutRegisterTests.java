package com.telran.oscar.tests.checkoutTests;

import com.telran.oscar.pages.*;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutWithoutRegisterTests extends TestBase {

    @Test
    public void checkoutWithoutRegisterPositiveTest() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AllProductsPage allProductsPage = new AllProductsPage(driver);

        sidePanelPage.clickOnBooksLink();
        booksPage.addProductAndCheckoutNow();
        checkoutPage.fillWhoAreYou();
        checkoutPage.fillWhereShouldWeShipTo();
        checkoutPage.choosePayment();
        checkoutPage.previewOrder();
        checkoutPage.confirmation();

        Assert.assertTrue(allProductsPage.existHeaderAllProducts());
    }

}
