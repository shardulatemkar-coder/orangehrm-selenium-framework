package com.orangehrm.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = ExtentManager.getInstance().createTest(testName);
		extentTest.set(test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		return extentTest.get();
	}
}
