package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        log.info("Login with data-->"+UserData.Email+"**********************"+UserData.Password);

        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginLink")));


        app.getUser().clickOnLoginLink();


        app.getUser().fillLoginForm(new User().setEmail(UserData.Email).setPassword(UserData.Password));


        app.getUser().clickOnLoginButton();


        Assert.assertTrue(app.getUser().isLoggedIn(), "User is not logged in");
    }
}
