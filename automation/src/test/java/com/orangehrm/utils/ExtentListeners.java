package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseTest;

public class ExtentListeners implements ITestListener{
	
//	WebDriver driver;
//	private static ExtentTest test;
	
	private static ExtentReports extent = ExtentManager.getReporter();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	
	try {
		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		String screenshotPath = ScreenshotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
		test.get().addScreenCaptureFromPath(screenshotPath);
	}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) { // --> this line tells that the method is overridden from ITestListener interface
		test.get().log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	}