package com.orangehrm.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private  static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String reportPath = "reports/ExtentReport.html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("OrangeHRM Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		return extent;
	}
	
	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}
}
