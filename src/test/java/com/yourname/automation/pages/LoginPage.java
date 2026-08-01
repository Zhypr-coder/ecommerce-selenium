package com.yourname.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
	
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;
    
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public ProductPage clickLogin() {
        click(loginButton);
        return new ProductPage();
    }

    // Convenience method for tests
    public ProductPage loginAs(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        return clickLogin();
    }
    
    public String getErrorMessage() {
        return getText(errorMessage);
    }
}