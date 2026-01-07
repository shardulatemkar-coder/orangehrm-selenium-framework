package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;

public class PIMPage extends BasePage{
	private By pimMenu =  By.xpath("//span[text() ='PIM']");
	private By addEmployee = By.xpath("//a[normalize-space()='Add Employee']");
	private By employeeList = By.xpath("//a[normalize-space()='Employee List']");
	
	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickPIMMenu() {
		click(pimMenu);
	}
	
	public void clickAddEmployee() {
		click(addEmployee);
	}
	
	public void clickEmployeeList() {
		click(employeeList);
	}
	
}
