package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .setEmail("bodyakina" + i + "@ukr.net")
                .setPassword("Qwerty1234@");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isUserLoggedIn());
    }
}
