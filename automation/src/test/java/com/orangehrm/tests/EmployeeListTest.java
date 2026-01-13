package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;


public class EmployeeListTest extends BaseTest {

	
	LoginPage login;
	MenuPage menu;
	EmployeeListPage empList;
	DashBoardPage dashboard;
	
	
	
	@BeforeClass
	public void setupPages() {
		login = new LoginPage(driver);
        menu = new MenuPage(driver);
        empList = new EmployeeListPage(driver);
        dashboard = new DashBoardPage(driver);
	}
	
	@Test(groups = {"regression"})
	public void searchAndDeleteEmployeeTest() {
		
		
		log.info("Starting Delete Employee Test");
		
		login.login("Admin","admin123");

		
		//Assert.assertTrue(login.isDashboardVisible(), "Dashboard not visible after login ");
		

		menu.clickPIM();
		menu.clickEmployeeList();
		Assert.assertTrue(empList.isEmployeeListHeaderVisible(), "Employee List Header not visible");
		
		
		String employeeName = "Sam Wick";
		
		empList.searchEmployee(employeeName);
		 Assert.assertTrue(empList.isEmployeeFound(employeeName),
	     "Employee '" + employeeName + "' was not found in search results.");

		
		empList.deleteEmpoyee(employeeName);
		Assert.assertTrue(empList.isDeleteSuccess(), "Delete success toast not visible ");
		
		empList.searchEmployee(employeeName);
		Assert.assertFalse(empList.isEmployeeFound(employeeName),
                "Employee still appears in list after delete operation.");

		log.info("--Employee List Tets Completed--");
	}
	
	
}
