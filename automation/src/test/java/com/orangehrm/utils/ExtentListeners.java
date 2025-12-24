package com.orangehrm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListeners implements ITestListener{
	
//	WebDriver driver;
//	private static ExtentTest test;

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		
		spark.config().setReportName("OrangeHRM Automation Test Report");
		spark.config().setDocumentTitle("Automation Execution Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		 extent.setSystemInfo("Framework", "Selenium TestNG");
	     extent.setSystemInfo("Tester", "Shardul A.");
	     extent.setSystemInfo("Environment", "QA");
	     
	     System.out.println("====Extent Report Started ====");
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testLogger.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		testLogger.get().pass("Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		testLogger.get().fail(" Test Failed : " + result.getThrowable());
		
		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		
		if (driver != null) {
			String screenshotPath = ScreenshotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
			
			testLogger.get().addScreenCaptureFromPath(screenshotPath);
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		testLogger.get().skip(" Test Skipped : " + result.getThrowable());

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("==== Extent Report Generated ====");
	}
	
}
	
//	private static ExtentReports extent = ExtentManager.getInstance();
//	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//	
//	@Override
//	public void onTestStart(ITestResult result) {
//		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
//		test.set(extentTest);
//	}
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		test.get().pass("Test Passed");
//	}
//	
//	@Override
//	public void onTestFailure(ITestResult result) {
//        test.get().fail(result.getThrowable());
//
//        WebDriver driver = ((BaseTest) result.getInstance()).driver;
//
//        String screenshotPath = ScreenshotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
//
//        try {
//            test.get().fail("Screenshot below:",
//                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//	
//	@Override
//	public void onTestSkipped(ITestResult result) { // --> this line tells that the method is overridden from ITestListener interface
//		test.get().log(Status.SKIP, "Test Skipped");
//	}
//	
//	@Override
//	public void onFinish(ITestContext context) {
//		extent.flush();
//	}
//	}