package com.orangehrm.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.factory.EmployeeDataFactory;
import com.orangehrm.flows.EmployeeFlows;
import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.Employee;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;


public class EmployeeListTest extends BaseTest {

	
	LoginPage login;
	MenuPage menu;
	EmployeeListPage empList;
	DashBoardPage dashboard;
	AddEmployeePages addEmployee;
	
	
	  @BeforeMethod(alwaysRun = true)
	    public void setupPages() {
	        login = new LoginPage(driver);
	        menu = new MenuPage(driver);
	        empList = new EmployeeListPage(driver);
	        dashboard = new DashBoardPage(driver);
	        addEmployee = new AddEmployeePages(driver);
	  }
	
	@Test(groups = {"regression"})
	public void searchAndDeleteEmployeeTest() {
		
		
		log.info("Starting Delete Employee Test");
		
		login.login("Admin","admin123");
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(),
				"Dashboard did not load properly");
		
		Employee employee = EmployeeDataFactory.createEmployee();
		
		EmployeeFlows flows = new EmployeeFlows(driver);
		
		flows.createEmployee(employee);
			
		menu.clickEmployeeList();
		Assert.assertTrue(empList.isEmployeeListHeaderVisible(), "Employee List Header not visible");
		
		
		
		empList.searchEmployee(employee.firstName());
		 Assert.assertTrue(empList.isEmployeeFound(employee.firstName()),
	     "Employee '" + employee.firstName() + "' was not found in search results.");
		 log.info("SEarched employee");
		
		 flows.deleteEmployee(employee.firstName());
		 Assert.assertTrue(empList.isDeleteSuccess());
		 log.info("DeletedEmployee");
		 
	
		 
//		empList.searchEmployee(employee.firstName());
//		Assert.assertFalse(empList.isEmployeeFound(employee.firstName()),
//                "Employee still appears in list after delete operation.");

		log.info("--Employee List Tets Completed--");
	}
}
