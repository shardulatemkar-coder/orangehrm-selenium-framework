package com.orangehrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.factory.DriverFactory;
import com.orangehrm.utils.ConfigReader;


public class BaseTest {
	
	public WebDriver driver;
	
	protected Logger log = LogManager.getLogger(this.getClass());

	
	@BeforeMethod(alwaysRun = true)
	public void setup() {

		driver = DriverFactory.initDriver();
		String url = ConfigReader.get("url");
		log.info("Opening URL: "+ url);
		driver.get(url);

		
		Reporter.getCurrentTestResult().getTestContext().setAttribute("WebDriver", driver);
		log.info("Browser launched and navigated to OrangeHRM login page");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Closing browser");
		DriverFactory.quitDriver();
		}
	}

