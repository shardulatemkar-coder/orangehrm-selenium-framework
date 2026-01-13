package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class DashboardTest extends BaseTest {
	
	@Test(groups = {"smoke"})
	public void verifyDashBoardElements() {
		LoginPage login = new LoginPage(driver);
		DashBoardPage dashboard = new DashBoardPage(driver);

		login.login("Admin","admin123");
		
		
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(), "Dashboard header is not available!");
		Assert.assertTrue(dashboard.isQuickLaunchPanelVisible(), "Quick Launch panel is not visible!");
	}
	

	
}
