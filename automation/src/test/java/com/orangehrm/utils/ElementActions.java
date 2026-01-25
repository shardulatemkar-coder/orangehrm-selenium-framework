package com.orangehrm.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

	private WebDriver driver;
	private WaitUtils wait;
	
	
	public ElementActions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}


	public void click(By locator) {
		WebElement element = wait.waitForClickable(locator);
		try {
			element.click();
		}catch(Exception e) {
			((JavascriptExecutor)driver)
			.executeScript("arguments[0].click();", element);
			}
		}

	public void click(WebElement element) {
	    WebElement el = wait.waitForClickable(element);
	    try {
	        el.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", el);
	    }
	}



	public void type(By locator, String text) {
		WebElement element = wait.waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void type(WebElement element, String text) {
		wait.waitForVisibility(element).clear();
		element.sendKeys(text);
	}

	public String getText(By locator) {
		return wait.waitForVisibility(locator).getText();
	}

	public String getText(WebElement element) {
		return wait.waitForVisibility(element).getText();
	}


	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public void jsClick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}


	public boolean isDisplayed(By locator) {
		try {
			return wait.waitForVisibility(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayed(WebElement element) {
		try {
			return wait.waitForVisibility(element).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<WebElement> getElements(By locator){
		wait.waitForPresence(locator);
		return driver.findElements(locator);
	}
	
	public boolean exists(By locator) {
		try {
			wait.waitForPresence(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
