package com.yourname.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(css = ".complete-header")
    private WebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public void fillDetails(String first, String last, String zip) {
        // wait for form to load
        wait.until(ExpectedConditions
            .visibilityOf(firstNameField));
        type(firstNameField, first);
        type(lastNameField, last);
        type(postalCodeField, zip);

        // wait for continue and click
        wait.until(ExpectedConditions
            .elementToBeClickable(continueButton));
        click(continueButton);

        // wait for order summary page to load
        wait.until(ExpectedConditions
            .urlContains("checkout-step-two"));
    }

    public void placeOrder() {
        // wait for finish button on order summary page
        wait.until(ExpectedConditions
            .urlContains("checkout-step-two"));
        wait.until(ExpectedConditions
            .elementToBeClickable(finishButton));
        click(finishButton);

        // wait for confirmation page
        wait.until(ExpectedConditions
            .urlContains("checkout-complete"));
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions
            .visibilityOf(confirmationMessage));
        return getText(confirmationMessage);
    }
}