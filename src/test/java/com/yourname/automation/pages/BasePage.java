package com.yourname.automation.pages;

import com.yourname.automation.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver,
            Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement el) {
        wait.until(ExpectedConditions
            .elementToBeClickable(el)).click();
    }
    
    protected void type(WebElement el, String text) {
        click(el);
        el.clear();
        el.sendKeys(text);
    }

    protected String getText(WebElement el) {
        return wait.until(ExpectedConditions
            .visibilityOf(el)).getText();
    }

    protected void waitForUrl(String urlPart) {
        wait.until(ExpectedConditions
            .urlContains(urlPart));
    }
}