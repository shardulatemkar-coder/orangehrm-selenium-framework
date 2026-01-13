package com.orangehrm.factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(DriverFactory.class);

    public static WebDriver initDriver() {

        String browser = ConfigReader.get("browser");
        int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));

        log.info("Initializing browser: " + browser);

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if ("true".equalsIgnoreCase(ConfigReader.get("headless"))) {
                    log.info("Running Chrome in HEADLESS mode");
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(options);
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        tlDriver.set(driver);
        log.info("Browser launched successfully");

        return driver;
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            log.info("Closing browser");
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
