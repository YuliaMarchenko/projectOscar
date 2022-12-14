package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage {
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Clothing')]")
    WebElement clothingLink;

    public ClothingPage clickOnClothingLink() {
        click(clothingLink);
        return new ClothingPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Books')]")
    WebElement booksLink;

    public BooksPage clickOnBooksLink() {
        click(booksLink);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),' Fiction')]")
    WebElement fictionLink;

    public BooksPage clickOnFictionLink() {
        click(fictionLink);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Computers in Literature')]")
    WebElement computersInLiteratureLink;

    public BooksPage clickOnComputersInLiteratureLink() {
        click(computersInLiteratureLink);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Non-Fiction')]")
    WebElement nonFictionLink;

    public BooksPage clickOnNonFictionLink() {
        click(nonFictionLink);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Essential programming')]")
    WebElement essentialProgrammingLink;

    public BooksPage clickOnEssentialProgrammingLink() {
        click(essentialProgrammingLink);
        return new BooksPage(driver);
    }

    @FindBy(xpath = "//aside//*[contains(text(),'Hacking')]")
    WebElement hackingLink;

    public BooksPage clickOnHackingLink() {
        click(hackingLink);
        return new BooksPage(driver);
    }
}
