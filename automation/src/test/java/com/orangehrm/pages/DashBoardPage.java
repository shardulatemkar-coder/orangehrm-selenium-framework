package com.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BasePage;

public class DashBoardPage extends BasePage {

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By quickLaunchPanel = By.xpath("//p[normalize-space()='Quick Launch'][1]"); // FIXED LOCATOR

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeaderVisible() {
       return isVisible(dashboardHeader);
    }

    public boolean isQuickLaunchPanelVisible() {
    	return isVisible(quickLaunchPanel);
    }
}

