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

    @Test
    public void checkoutWithoutRegisterAddTwoBooksPositiveTest() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        sidePanelPage.clickOnBooksLink();
        Double expectedSumProducts = booksPage.getPriceFirstBook() + booksPage.getPriceSecondBook();
        booksPage.addSecondProductInBasket();
        booksPage.addProductAndCheckoutNow();
        checkoutPage.fillWhoAreYou();
        checkoutPage.fillWhereShouldWeShipTo();
        checkoutPage.choosePayment();

        Assert.assertEquals(expectedSumProducts, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedSumProducts, basketPage.getPriceOrderTotalAsDouble());

        checkoutPage.previewOrder();

        Assert.assertEquals(expectedSumProducts, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedSumProducts, basketPage.getPriceOrderTotalAsDouble());

        checkoutPage.confirmation();

        Assert.assertTrue(allProductsPage.existHeaderAllProducts());
    }

    @Test
    public void checkoutWithoutRegisterAddTwoSameBookPositiveTest() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        sidePanelPage.clickOnBooksLink();
        Double expectedPrice = 2 * booksPage.getPriceFirstBook();
        booksPage.addProductInBasketAndViewBasket();
        basketPage.changeQuantityBook("2");

        basketPage.clickProceedToCheckout();

        checkoutPage.fillWhoAreYou();
        checkoutPage.fillWhereShouldWeShipTo();
        checkoutPage.choosePayment();

        Assert.assertEquals(expectedPrice, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedPrice, basketPage.getPriceOrderTotalAsDouble());

        checkoutPage.previewOrder();

        Assert.assertEquals(expectedPrice, basketPage.getPriceBasketTotalAsDouble());
        Assert.assertEquals(expectedPrice, basketPage.getPriceOrderTotalAsDouble());

        checkoutPage.confirmation();

        Assert.assertTrue(allProductsPage.existHeaderAllProducts());
    }
}
