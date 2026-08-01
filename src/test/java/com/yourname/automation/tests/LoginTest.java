package com.yourname.automation.tests;

import com.yourname.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login redirects to products page")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", "secret_sauce");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory"),
            "Login failed - not redirected to inventory page"
        );
    }

    @Test(description = "Invalid credentials shows error message")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("wrong_user", "wrong_pass");
        Assert.assertTrue(
            loginPage.getErrorMessage().length() > 0,
            "Error message not shown for invalid login"
        );
    }

    @Test(description = "Empty credentials shows validation error")
    public void testEmptyLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickLogin();
        Assert.assertFalse(
            loginPage.getErrorMessage().isEmpty(),
            "No error shown for empty login"
        );
    }
}