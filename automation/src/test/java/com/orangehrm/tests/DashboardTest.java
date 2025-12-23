package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.DashBoardPage;
import com.orangehrm.pages.LoginPage;

public class DashboardTest extends BaseTest {
	
	@Test
	public void verifyDashBoardElements() {
		LoginPage login = new LoginPage(driver);
		login.login("Admin","admin123");
		
		DashBoardPage dashboard = new DashBoardPage(driver);
		
		Assert.assertTrue(dashboard.isDashboardHeaderVisible(), "Dashboard header is not available!");
		Assert.assertTrue(dashboard.isQuickLaunchPanelVisible(), "Quick Launch panel is not visible!");
	}
	

	
}
