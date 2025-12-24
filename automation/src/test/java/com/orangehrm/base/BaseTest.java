package com.orangehrm.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	protected Logger log = LogManager.getLogger(this.getClass());

	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Reporter.getCurrentTestResult().getTestContext().setAttribute("WebDriver", driver);
		log.info("Browser launched and navigated to OrangeHRM login page");
	}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			log.info("Closing browser adn quitting driver");
			driver.quit();
		}
	}

}
