package com.orangehrm.factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.utils.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	
    public static WebDriver initDriver() {

        String browser = ConfigReader.get("browser");
        int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));

        log.info("Initializing browser: " + browser);

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException(
                    "❌ Invalid browser name in config.properties → " + browser +
                    " | Allowed: chrome, edge, firefox"
                );
        }

        driver.manage().window().maximize();
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(implicitWait));

        log.info("Browser launched successfully");
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
            driver = null;
        }
    }
}
