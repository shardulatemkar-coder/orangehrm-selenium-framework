package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;

public class PIMPage extends BasePage{
	private By pimMenu =  By.xpath("//span[text() ='PIM']");
	private By addEmployee = By.xpath("//button[normalize-space()='Add']");
	private By employeeList = By.xpath("//a[normalize-space()='Employee List']");
	
	public PIMPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickPIMMenu() {
		waitForClickability(pimMenu).click();
	}
	
	public void clickAddEmployee() {
		waitForClickability(addEmployee).click();
	}
	
	public void clickEmployeeList() {
		waitForClickability(employeeList).click();
	}
	
}
