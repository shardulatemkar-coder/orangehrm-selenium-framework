package com.orangehrm.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.orangehrm.utils.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import com.orangehrm.reports.ExtentManager;
import com.orangehrm.reports.ExtentTestManager;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());

        Object testClass = result.getInstance();
        WebDriver driver = ((com.orangehrm.base.BaseTest) testClass).driver;

        // Screenshot
        String screenshotPath = ScreenshotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}
