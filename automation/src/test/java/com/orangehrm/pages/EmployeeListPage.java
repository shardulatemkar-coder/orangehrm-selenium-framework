package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.base.BasePage;

public class EmployeeListPage extends BasePage {

	private By employeeNameField = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
	private By searchBtn = By.xpath("//button[@type='submit']");
	private By employeeTableRows = By.xpath("//div[contains(@class,'orangehrm-container')]/div");
	//private By employeeTableRows = By.xpath("//div[@role='table']");
	private By deleteIcons = By.xpath("//button[i[contains(@class,'bi-trash')]]");
	private By confirmDeleteBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
	private By successToast = By.xpath("//div[@id='oxd-toaster_1']");
	
	public EmployeeListPage(WebDriver driver) {
		super(driver);
	}
	
	public void searchEmployee(String employeeName) {
		waitForVisibility(employeeNameField).sendKeys(employeeName);
		waitForClickability(searchBtn).click();
	}
	
	public boolean isEmployeeFound(String employeeName) {
		List<WebElement> rows = driver.findElements(employeeTableRows);
		
		for(WebElement row : rows) {
			if (row.getText().contains(employeeName)) {
				return true;
			}
		}
		return false;
	}

	public void deleteEmpoyee(String employeeName) {
		
		searchEmployee(employeeName);
		
		List<WebElement> rows = waitForVisibility(employeeTableRows)
				.findElements(By.xpath(employeeName));
		
		for(WebElement row :rows) {
			if (row.getText().contains(employeeName)) {
				row.findElement(By.xpath("//button[i[contains(@class,'bi-trash')]]")).click();
				break;
			}
		}
		waitForClickability(confirmDeleteBtn).click();
	}
	
	public boolean isDeleteSuccess() {
		return isVisible(successToast);
	}
}
