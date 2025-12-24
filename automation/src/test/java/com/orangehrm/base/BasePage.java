package com.orangehrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected Logger log = LogManager.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForVisibility(By locator) {
        return WaitUtils.waitForVisibility(driver, locator, 10);
    }

    protected WebElement waitForClickability(By locator) {
        return WaitUtils.waitForClickability(driver, locator, 10);
    }

    protected boolean isVisible(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}