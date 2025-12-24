package com.orangehrm.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BasePage;

public class LoginPage extends BasePage {
	

	WebDriverWait wait;
	
	//Locators
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By profileHeader = By.xpath("//h6[contains(text(), 'Dashboard')]");
	private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
	
	public LoginPage(WebDriver driver) {
        super(driver);
     
    }
	
	public void enterUsername(String user) {
		log.info("Entering username : "+  user);
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		log.info("Entering passord");
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		log.info("Clicking login button");
		driver.findElement(loginBtn).click();
	}
	
	public String getErrorMessage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		 try {
			 WebElement invalid = waitForVisibility(errorMessage);
			 return invalid.getText().trim();
		 }catch (Exception e) {}
		 
		 try {
			 WebElement required = waitForVisibility(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]"));
			 return required.getText().trim();
		 }catch (Exception e) {
			 return null;
		 }
//		try {
//			WebElement invalid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));
//	        return invalid.getText();
//					
//		}catch (Exception e) {
//			
//		}
//		
//		try {
//			WebElement required = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")));
//			return required.getText().trim();
//		}catch (Exception e) {
//			return null;
//		}
}
	
	public boolean isDashboardVisible() {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeader));
	        return driver.findElement(profileHeader).isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	 public void login(String user, String pass) {
	        waitForVisibility(username).sendKeys(user);
	        waitForVisibility(password).sendKeys(pass);
	        waitForClickability(loginBtn).click();
	    }
}
