package com.orangehrm.tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.TestDataReader;



public class LoginTest extends BaseTest {
	
	
	
	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData(){
		
		String data = TestDataReader.get("invalid.data");
		String[] credentials = data.split(",");
		
		Object[][] testData = new Object[credentials.length][2];
		
		for(int i = 0;i < credentials.length; i++) {
			String[]userPass =credentials[i].split(":",-1);
			testData[i][0] = userPass[0];
			testData[i][1] = userPass[1];
		}
		return testData;
	}
	@Test(groups = {"smoke"})
	public void validLoginTest() {
		  log.info("Starting valid login test");
		  
		  LoginPage login = new LoginPage(driver);
		  DashBoardPage dashboard = new DashBoardPage(driver);
		  
		  login.login(
				    TestDataReader.get("valid.username"),
				    TestDataReader.get("valid.password")
				);
		  log.info("Logged in successfully");
		  
		  Assert.assertTrue(dashboard.isDashboardHeaderVisible(), "DashBoard is not visible !");
		  log.info("Valid login test passed");
				
	}
	
	@Test(dataProvider = "invalidLoginData" , groups = {"regression"})
	public void invalidLoginTest(String username, String password) {
		
		log.info("Running invalid login test with: " + username + " / " + password);

		driver.navigate().refresh();
		
		LoginPage login = new LoginPage(driver);
		login.login(username, password);
		
		if(username.isEmpty() || password.isEmpty()) {
			Assert.assertTrue(login.isRequiredFieldErrorVisible(),
			"Required feild validation message not shown ");
		}else {
			String error = login.getErrorMessage();
			Assert.assertEquals(error,"Invalid credentials",
					"Invalid credentials message not shown ");
		}
		

	}
}