package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.utils.ElementActions;

public class EmployeeListPage  {

	private WebDriver driver;
	private ElementActions actions;
	
	private By employeeNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By searchBtn = By.xpath("//button[@type='submit']");
	private By employeeTableRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");

	private By deleteIcons = By.xpath("//button[i[contains(@class,'bi-trash')]]");
	private By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
	private By successToast = By.xpath("//div[@id='oxd-toaster_1']");
	private By empListHeader = By.xpath("//h5[text() = 'Employee Information']");
	private By employeeFirstName = By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][3]");
	
	
	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ElementActions(driver);
	}
	
	public void searchEmployee(String employeeName) {
		actions.type(employeeNameField, employeeName);
		actions.click(searchBtn);
		actions.isDisplayed(employeeFirstName);
	}
	
	public boolean isEmployeeFound(String firstName) {
		
		List<WebElement> names = actions.getElements(employeeFirstName);
		if(names.isEmpty()) {
			return false;
	        }
		for(WebElement name : names) {
			if(name.getText().contains(firstName)) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteEmpoyee(String firstName) {

		actions.click(deleteIcons);
		actions.click(confirmDeleteBtn);
	}

	
	public boolean isDeleteSuccess() {
		return actions.isDisplayed(successToast);
	}
	
	public boolean isEmployeeListHeaderVisible() {
		return actions.isDisplayed(empListHeader);
	}
	public String getFirstResultName() {
		return actions.getText(employeeFirstName);
	}
}
