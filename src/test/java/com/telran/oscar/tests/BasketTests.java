package com.telran.oscar.tests;

import com.telran.oscar.pages.BasketPage;
import com.telran.oscar.pages.BooksPage;
import com.telran.oscar.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasketTests extends TestBase {

    @Test
    public void addProductInBasket(){

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        sidePanelPage.clickOnBooksLink();
        String expectedResultPriceBook = booksPage.getPriceFirstBookAsString();
        booksPage.addProductInBasketAndViewBasket();

        Assert.assertEquals(expectedResultPriceBook, basketPage.getPriceBasketTotalAsString());
        Assert.assertTrue(basketPage.existHeaderBasket());
    }
}
