package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLoginTest() {
		LoginPage login = new LoginPage(driver); //-->Type casting is done to provide more methods of login page into driver
		login.login("Admin", "admin123");
		
	
		System.out.println("Current URL : " + driver.getCurrentUrl());
		System.out.println("Page Title : " + driver.getTitle());
		
		
		
	}

}
