package com.orangehrm.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;



public class LoginTest extends BaseTest {

	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData(){
		return new Object[][] {
				{"wrongUser", "admin123"},
				{"Admin","wrongPass"},
				{"wrongUser","wrongPass"},
				{"","admin"},
				{"Admin",""}
		};
	}
	@Test
	public void validLoginTest() {
		LoginPage login = new LoginPage(driver); //-->Type casting is done to provide more methods of login page into driver
		login.login("Admin", "admin123");
		
	
		System.out.println("Current URL : " + driver.getCurrentUrl());
		System.out.println("Page Title : " + driver.getTitle());
				
	}
	
	@Test(dataProvider = "invalidLoginData")
	public void invalidLoginTest(String username, String password) {
		
		log.info("Running invalid login test with: " + username + " / " + password);

		
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		
		String error = login.getErrorMessage();
		
		Assert.assertNotNull(error, "Error message not shown for invalid login!");
		Assert.assertTrue(error.equals("Invalid credentials") || error.equals("Required"),
				"Unexpected error message: " + error);
		

	}
}