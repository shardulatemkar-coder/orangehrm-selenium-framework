	
	package com.orangehrm.utils;
	
	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
	

	
	public class WaitUtils {
	
		private WebDriver driver;
		private WebDriverWait wait;
		
		public WaitUtils(WebDriver driver) {
			this.driver= driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		}
		
		public WebElement waitForVisibility(WebElement element) {
			return wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public WebElement waitForVisibility(By locator) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		public WebElement waitForClickable(WebElement element) {
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public WebElement waitForClickable(By locator) {
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
		
		
		public WebElement waitForPresence(By locator) {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public void waitForTitle(String title) {
			wait.until(ExpectedConditions.titleContains(title));
		}
		
		public WebElement fluentWait(By locator) {
			FluentWait<WebDriver> fluent = new FluentWait<>(driver)
			.withTimeout(Duration.ofSeconds(20))
			.pollingEvery(Duration.ofSeconds(1))
			.ignoring(Exception.class);
			
			return fluent.until(driver -> driver.findElement(locator));
		}	
	}
