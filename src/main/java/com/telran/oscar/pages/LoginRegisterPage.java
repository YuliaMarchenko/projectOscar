package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterPage extends BasePage {

    public LoginRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement registerEmail;

    @FindBy(id = "id_registration-password1")
    WebElement registerPassword;

    @FindBy(id = "id_registration-password2")
    WebElement registerConfirmPassword;

    @FindBy(css = "[name='registration_submit']")
    WebElement buttonRegister;

    public HomePage register(String email, String password, String passwordConfirm) {
        type(registerEmail, email);
        type(registerPassword, password);
        type(registerConfirmPassword, passwordConfirm);
        click(buttonRegister);
        return new HomePage(driver);
    }

    @FindBy(id = "id_login-username")
    WebElement loginEmail;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(css = "[name='login_submit']")
    WebElement buttonLogIn;

    public HomePage login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(buttonLogIn);
        return new HomePage(driver);
    }
}
