package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean existHeaderBooks() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Books')]")).size() > 0;
    }

    public boolean existHeaderFiction() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Fiction')]")).size() > 0;
    }

    public boolean existHeaderComputersInLiterature() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Computers in Literature')]")).size() > 0;
    }

    public boolean existHeaderNonFiction() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Non-Fiction')]")).size() > 0;
    }

    public boolean existHeaderEssentialProgramming() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Essential programming')]")).size() > 0;
    }

    public boolean existHeaderHacking() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Hacking')]")).size() > 0;
    }
}
