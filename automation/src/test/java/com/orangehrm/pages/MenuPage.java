package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;

public class MenuPage extends BasePage {
	
	private By pimMenu = By.xpath("//span[text()='PIM']");
    private By dashboardMenu = By.xpath("//span[text()='Dashboard']");
    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By timeMenu = By.xpath("//span[text()='Time']");
    private By recruitmentMenu = By.xpath("//span[text()='Recruitment']");
    
    // submenus
    private By employeeList = By.xpath("//a[normalize-space()='Employee List']");
    private By addEmployee =By.xpath("//a[normalize-space()='Add Employee']");
    
	public MenuPage(WebDriver driver) {
		super(driver);
	}

	public void clickDashboard(){
		click(dashboardMenu);
	}
	public void clickAdmin(){
		click(adminMenu);
	}
	public void clickPIM(){
		click(pimMenu);
	}
	public void clickLeave(){
		click(leaveMenu);
	}
	public void clickTime(){
		click(timeMenu);
	}
	public void clickRecruitment(){
		click(recruitmentMenu);
	}
	
	//Submenus
	public void clickEmployeeList(){
		click(employeeList);
	}
	public void clickAddEmployee(){
		click(addEmployee);
	}
}
