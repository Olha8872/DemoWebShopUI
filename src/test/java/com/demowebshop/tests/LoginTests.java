package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        User user = new User()
                .setEmail("sitiuk@gmail.com")
                .setPassword("Qwerty123@");

        app.getUser().openLoginForm();         //waiting for login form
        app.getUser().fillLoginForm(user);    // enters login/password
        app.getUser().submitLogin();          // clicks on the login button

        Assert.assertTrue(app.getUser().isUserLoggedIn()); // login check
    }
}

