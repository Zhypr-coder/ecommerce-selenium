package com.yourname.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }
}