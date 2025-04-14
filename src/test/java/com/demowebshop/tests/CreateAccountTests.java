package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Click on register link
        click(By.cssSelector("a.ico-register"));

        // Fill the registration form
        click(By.id("gender-female"));
        type(By.id("FirstName"), "Olga");
        type(By.id("LastName"), "Bodyakina");

        // Wait for email field and enter unique email

        type(By.id("Email"), "bodyakina" + i + "@ukr.net");

        // Enter password and confirmation
        type(By.id("Password"), "Qwerty1234@");
        type(By.id("ConfirmPassword"), "Qwerty1234@");

        // Submit registration
        click(By.id("register-button"));

        // Verify successful registration
        Assert.assertTrue(isElementPresent(By.cssSelector(".ico-logout")));

        // Click Continue
        click(By.cssSelector(".register-continue-button"));
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        click(By.cssSelector("a.ico-register"));
        click(By.id("gender-female"));
        type(By.id("FirstName"), "Olga");
        type(By.id("LastName"), "Sitiuk");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        type(By.id("Email"), "sitiuk@gmail.com");

        type(By.id("Password"), "Qwerty123@");
        type(By.id("ConfirmPassword"), "Qwerty123@");

        click(By.id("register-button"));

        // Verify successful registration
        Assert.assertTrue(isElementPresent(By.cssSelector(".message-error")));
    }

}
