package com.telran.oscar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllProductsPage extends HomePage{
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean existHeaderAllProducts() {
        return driver.findElements(By.xpath("//h1[contains(text(),'All products')]")).size() > 0;
    }
}
