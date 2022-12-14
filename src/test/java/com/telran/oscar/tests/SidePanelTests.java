package com.telran.oscar.tests;

import com.telran.oscar.pages.BooksPage;
import com.telran.oscar.pages.ClothingPage;
import com.telran.oscar.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SidePanelTests extends TestBase {

    @Test
    public void checkClickabilityClothingLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        ClothingPage clothingPage = new ClothingPage(driver);

        sidePanelPage.clickOnClothingLink();

        Assert.assertTrue(clothingPage.existHeaderClothing());
    }

    @Test
    public void checkClickabilityBooksLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnBooksLink();

        Assert.assertTrue(booksPage.existHeaderBooks());
    }

    @Test
    public void checkClickabilityFictionLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnFictionLink();

        Assert.assertTrue(booksPage.existHeaderFiction());
    }

    @Test
    public void checkClickabilityComputersInLiteratureLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnComputersInLiteratureLink();

        Assert.assertTrue(booksPage.existHeaderComputersInLiterature());
    }

    @Test
    public void checkClickabilityNonFictionLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnNonFictionLink();

        Assert.assertTrue(booksPage.existHeaderNonFiction());
    }

    @Test
    public void checkClickabilityEssentialProgrammingLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnEssentialProgrammingLink();

        Assert.assertTrue(booksPage.existHeaderEssentialProgramming());
    }

    @Test
    public void checkClickabilityHackingLink() {

        SidePanelPage sidePanelPage = new SidePanelPage(driver);
        BooksPage booksPage = new BooksPage(driver);

        sidePanelPage.clickOnHackingLink();

        Assert.assertTrue(booksPage.existHeaderHacking());
    }

}
