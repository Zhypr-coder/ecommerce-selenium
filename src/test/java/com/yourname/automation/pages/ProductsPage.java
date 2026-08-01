package com.yourname.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(css = ".btn_inventory")
    private WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addFirstItemToCart() {
        click(addToCartButton);
    }

    public CartPage goToCart() {
        click(cartIcon);
        wait.until(ExpectedConditions.urlContains("cart"));
        return new CartPage();
    }
}