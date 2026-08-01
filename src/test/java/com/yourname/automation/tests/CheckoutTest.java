package com.yourname.automation.tests;

import com.yourname.automation.pages.CartPage;
import com.yourname.automation.pages.CheckoutPage;
import com.yourname.automation.pages.LoginPage;
import com.yourname.automation.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Complete full checkout flow")
    public void testSuccessfulCheckout() {

        // Step 1 - Login
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", "secret_sauce");

        // Step 2 - Verify on products page
        Assert.assertTrue(
            driver.getCurrentUrl().contains("inventory"),
            "Login failed"
        );

        // Step 3 - Add item to cart
        ProductsPage productsPage = new ProductsPage();
        productsPage.addFirstItemToCart();

        // Step 4 - Go to cart
        CartPage cartPage = productsPage.goToCart();
        Assert.assertTrue(
            driver.getCurrentUrl().contains("cart"),
            "Cart page not opened"
        );

        // Step 5 - Proceed to checkout
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        Assert.assertTrue(
            driver.getCurrentUrl().contains("checkout-step-one"),
            "Checkout page not opened"
        );

        // Step 6 - Fill details and continue
        checkoutPage.fillDetails("John", "Doe", "411001");
        Assert.assertTrue(
            driver.getCurrentUrl().contains("checkout-step-two"),
            "Order summary page not opened"
        );

        // Step 7 - Place order
        checkoutPage.placeOrder();

        // Step 8 - Verify confirmation
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(
            confirmation,
            "Thank you for your order!",
            "Confirmation message mismatch"
        );
    }
}