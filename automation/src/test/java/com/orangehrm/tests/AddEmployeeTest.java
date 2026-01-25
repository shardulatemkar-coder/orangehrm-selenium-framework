package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.AddEmployeePages;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MenuPage;
import com.orangehrm.utils.TestDataUtils;

public class AddEmployeeTest extends BaseTest {
	
	
	@Test(groups = {"regression" , "employee"})
	public void addNewEmployeeTest() {
		LoginPage login = new LoginPage(driver);
		login.login("Admin","admin123");
		System.out.println(
			    "Hamburger present: " +
			    driver.findElements(
			        By.xpath("//button[contains(@class,'oxd-main-menu-button')]")
			    ).size()
			);
		System.out.println("Page title: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());

		DashBoardPage dashboard = new DashBoardPage(driver);
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(),
				"Dashboard is not visible after login ");
	
		
		 MenuPage menu = new MenuPage(driver);
	        menu.clickPIM();
	        menu.clickAddEmployee();
	        
		AddEmployeePages addEmp = new AddEmployeePages(driver);
		String firstName = TestDataUtils.getRandomFirstName();
		String LastName = TestDataUtils.getRandomLastName();
		String empId = TestDataUtils.getRandomEmployeeId();
		String fullName =(firstName + " " + LastName);
		
		addEmp.addEmployee(firstName, "F", LastName, empId);
		
		Assert.assertTrue(addEmp.isPersonalHeaderVisible(),
				"Personal Details page did not appear after saving ");
		log.info("Add Employee Test passed Sucessfully ");
		
	}

}
