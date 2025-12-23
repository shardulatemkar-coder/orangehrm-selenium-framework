package com.orangehrm.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			reporter.config().setReportName("Automation Report");
			reporter.config().setDocumentTitle("OrangeHRM Test Report");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	
}
