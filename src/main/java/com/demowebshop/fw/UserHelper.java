package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        click(By.cssSelector("a.ico-login"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.cssSelector("input.button-1.login-button"));
    }


    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector(".ico-logout"));
    }

    public void openRegistrationForm() {
        click(By.cssSelector("a.ico-register"));
    }

    public void fillRegistrationForm(User user) {
        click(By.id("gender-female"));
        type(By.id("FirstName"), "TestFirstName");
        type(By.id("LastName"), "TestLastName");
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void submitRegistration() {
        click(By.id("register-button"));
    }
}
