package com.orangehrm.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	//Locators
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//button[@type= 'submit']");
	private By profileHeader = By.xpath("//h6[contains(text(), 'Dashboard')]");
	private By errorMessage = By.xpath("//div[@role='alert']//p");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public String getErrorMessage() {
		try {
			WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']//p")));
			return driver.findElement(errorMessage).getText();
		}catch(Exception e) {
			return null;
		}
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		
		enterUsername(user);
		enterPassword(pass);
		clickLogin();
	}
}
