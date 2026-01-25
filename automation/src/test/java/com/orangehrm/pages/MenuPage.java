package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.ElementActions;

public class MenuPage  {
	private WebDriver driver;
    private ElementActions actions;
 
	
 private By sidePanel       = By.xpath("//aside[contains(@class,'oxd-sidepanel')]");
	private By pimMenu         = By.xpath("//span[normalize-space()='PIM']");
	private By dashboardMenu   = By.xpath("//span[normalize-space()='Dashboard']");
	private By adminMenu       = By.xpath("//span[normalize-space()='Admin']");
	private By leaveMenu       = By.xpath("//span[normalize-space()='Leave']");
	private By timeMenu        = By.xpath("//span[normalize-space()='Time']");
	private By recruitmentMenu = By.xpath("//span[normalize-space()='Recruitment']");

    
    // submenus
    private By employeeList = By.xpath("//a[normalize-space()='Employee List']");
    private By addEmployee =By.xpath("//a[normalize-space()='Add Employee']");
    
	public MenuPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
	}
	
	
	private void ensureSidePanelVisible() {
		actions.isDisplayed(sidePanel);
	}
	
	public void clickDashboard(){
		actions.click(dashboardMenu);
	}
	
	public void clickAdmin(){
		actions.click(adminMenu);
	}
	
	public void clickPIM(){
		ensureSidePanelVisible();
		actions.click(pimMenu);
	}
	
	public void clickLeave(){
		actions.click(leaveMenu);
	}
	
	public void clickTime(){
		actions.click(timeMenu);
	}
	
	public void clickRecruitment(){
		actions.click(recruitmentMenu);
	}
	
	
	//Submenus
	public void clickEmployeeList(){
		ensureSidePanelVisible();
		actions.click(employeeList);
	}
	public void clickAddEmployee(){
		ensureSidePanelVisible();
		actions.click(addEmployee);
	}
}
