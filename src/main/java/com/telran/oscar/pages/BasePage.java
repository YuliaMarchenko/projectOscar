package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public Screenshot takeScreenhotWithScrollDown(){
        Screenshot screen = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.5f),1000))
                .takeScreenshot(driver);
        try {
            ImageIO.write(screen.getImage(), "png",
                    new File("screenshot/screen", System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screen;
    }
}
