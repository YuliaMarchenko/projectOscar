package com.telran.oscar.tests.booksTests;

import com.telran.oscar.pages.BooksPage;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksReviewTests extends TestBase {

    @Test
    public void writeReviewPositiveTest(){

        BooksPage booksPage = new BooksPage(driver);

        booksPage.writeReview();

        Assert.assertTrue(booksPage.existCustomerReviews());
    }
}
