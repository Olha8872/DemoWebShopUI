package com.demowebshop.fw;

import com.demowebshop.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AppManager {

    private WebDriver driver;
    private Logger logger = LoggerFactory.getLogger(AppManager.class);

    private UserHelper userHelper;
    private CartHelper cartHelper;
    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                logger.info("Test started in Chrome browser");
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                logger.info("Test started in Firefox browser");
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebDriverListener listener = new MyListener();
            driver = new EventFiringDecorator<>(listener).decorate(driver);


            driver.get("http://demowebshop.tricentis.com/");
            logger.info("Current URL: " + driver.getCurrentUrl());


            userHelper = new UserHelper(driver);
            cartHelper = new CartHelper(driver);
        } catch (Exception e) {
            logger.error("Error during initialization: ", e);
            throw new RuntimeException("Browser initialization failed: " + e.getMessage());
        }
    }

    public void stop() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
        } catch (Exception e) {
            logger.error("Error while closing the browser: ", e);
        }
    }

    public UserHelper getUser() {
        return userHelper;
    }

    public CartHelper getCart() {
        return cartHelper;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
