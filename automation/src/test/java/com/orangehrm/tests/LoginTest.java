package com.orangehrm.tests;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.LoggerLoad;



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
		  log.info("Starting valid login test");
		  
		  LoginPage login = new LoginPage(driver);
		  
		  login.enterUsername("Admin");
		  log.info("Entered username");
		  
		  login.enterPassword("admin123");
		  log.info("Entered password");
		  
		  login.clickLogin();
		  log.info("Clicked Login button");
		  
		  Assert.assertTrue(login.isDashboardVisible(), "DashBoard is not visible !");
		  log.info("Valid login test passed");
				
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