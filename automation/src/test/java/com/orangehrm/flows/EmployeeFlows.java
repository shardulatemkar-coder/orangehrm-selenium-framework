package com.orangehrm.flows;

import org.openqa.selenium.WebDriver;

import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.Employee;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.MenuPage;

public class EmployeeFlows {
	
	private MenuPage menu;
	private AddEmployeePages addEmployee;
	private EmployeeListPage empList;
	
	public EmployeeFlows(WebDriver driver) {
	
		this.menu = new MenuPage(driver);
		this.addEmployee = new AddEmployeePages(driver);
		this.empList = new EmployeeListPage(driver);
	}

	public void createEmployee(Employee employee) {
		menu.clickPIM();
		menu.clickAddEmployee();
		
		addEmployee.addEmployee(
		        employee.firstName(),
		        employee.middleName(),
		        employee.lastName(),
		        employee.employeeId()
		    );
	}
	
	public void deleteEmployee(String firstName) {
		
		
		empList.deleteEmpoyee(firstName);
	}
}
