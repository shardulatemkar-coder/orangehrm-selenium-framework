package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orangehrm.base.BasePage;

public class DashBoardPage extends BasePage {

    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By quickLaunchPanel = By.xpath("//p[normalize-space()='Quick Launch'][1]"); // FIXED LOCATOR
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeaderVisible() {
    	return isVisible(dashboardHeader);
    }

    public void goToEmployeeList() {
    	click(pimMenu);
    	click(employeeListMenu);
    }
    
    public boolean isQuickLaunchPanelVisible() {
    	return isVisible(quickLaunchPanel);
    }
}

