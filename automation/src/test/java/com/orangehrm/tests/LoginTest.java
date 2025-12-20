package com.orangehrm.tests;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
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
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		
		String error = login.getErrorMessage();
		
		Assert.assertNotNull(error, "Error message not shown for invaild login !");;
		Assert.assertEquals(error,  "Invalid credentials");
	}
}