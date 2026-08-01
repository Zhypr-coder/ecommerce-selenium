package com.yourname.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(css = ".cart_item_label")
    private WebElement cartItem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isItemInCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cartItem));
            return cartItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public CheckoutPage proceedToCheckout() {
        click(checkoutButton);
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
        return new CheckoutPage(driver);
    }
}