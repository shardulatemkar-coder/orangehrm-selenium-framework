package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.base.BasePage;

public class AddEmployeePages extends BasePage {
	
	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By employeeId =By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
	private By saveBtn = By.xpath("//button[@type='submit']");
	
	private By personaDetailsHeader =By.xpath("//h6[text()='Personal Details']");
	
	public AddEmployeePages(WebDriver driver) {
		super(driver);
	}
	
	public void enterFirstName(String fname) {
		waitForVisibility(firstName).sendKeys(fname);
	}
	
	public void enterMiddleName(String mname) {
		waitForVisibility(middleName).sendKeys(mname);
	}
	
	public void enterLastName(String lname) {
		waitForVisibility(lastName).sendKeys(lname);
	}
	
	public void enterEmpoyeeId(String empId) {
		waitForVisibility(employeeId).clear();
		waitForVisibility(employeeId).sendKeys(empId);
		}
	
	public void clickSave() {
		waitForClickability(saveBtn).click();
	}
	
	public boolean isPersonalHeaderVisible() {
		return isVisible(personaDetailsHeader);
	}
	
	public void addEmployee(String fname, String mname, String lname, String empId) {
		enterFirstName(fname);
		enterMiddleName(mname);
		enterLastName(lname);
		enterEmpoyeeId(empId);
		clickSave();
	}

}
