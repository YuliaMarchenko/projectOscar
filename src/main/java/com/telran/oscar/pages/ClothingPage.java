package com.telran.oscar.pages;

import com.telran.oscar.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClothingPage extends BasePage {
    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    public boolean existHeaderClothing() {
        return driver.findElements(By.xpath("//h1[contains(text(),'Clothing')]")).size() > 0;
    }
}
