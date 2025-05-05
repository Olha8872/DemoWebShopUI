package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
    }

    public void clickOnRegistrationButton() {
        click(By.linkText("Register"));
    }

    public void fillRegisterForm(String firstName, String lastName, String email, String password) {
        type(By.id("First_Name"), firstName);
        type(By.id("Last_Name"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("Confirm_Password"), password);
    }

    public void submitRegistration() {
        click(By.id("register-button"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.linkText("Log out"));
    }

    public void clickOnLoginLink() {
        waitForElementVisible(By.cssSelector("a.ico-login"), 10);
        click(By.cssSelector("a.ico-login"));
    }

    private void waitForElementVisible(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("input.button-1.login-button"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.linkText("Log in"));
    }

    public void clickOnSignOutButton() {
        click(By.linkText("Log out"));
    }

    public String takeScreenshotOnFailure() {
        try {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + System.currentTimeMillis() + ".png";
            File destination = new File(screenshotPath);

            File screenshotDir = new File("screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            FileUtils.copyFile(screenshot, destination);
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void register(User user) {
        clickOnRegistrationButton();
        fillRegisterForm(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        submitRegistration();
        if (isUserLoggedIn()) {
            System.out.println("User successfully registered and logged in");
        } else {
            String screenshotPath = takeScreenshotOnFailure();
            System.out.println("User registration failed. Screenshot: " + screenshotPath);
        }
    }

    public boolean isUserLoggedIn() {
        return isSignOutButtonPresent();
    }

    public void fillRegistrationForm(User user) {
        type(By.id("First_Name"), user.getFirstName());
        type(By.id("Last_Name"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("Confirm_Password"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.linkText("Log out"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input.button-1.login-button"));  // or another CSS selector for the login button
    }

    public void openRegistrationForm() {
        driver.get("https://demowebshop.com/register"); // Example URL for the registration page
    }
}
