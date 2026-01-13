package com.orangehrm.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utils.ConfigReader;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log = LogManager.getLogger(this.getClass());

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.get("explicitWait"))
                )
        );
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickability(locator).click();
    }

    protected void type(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisibility(locator).getText().trim();
    }

    protected boolean isVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
