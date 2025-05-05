package com.demowebshop.tests;

import com.demowebshop.fw.AppManager;
import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    private AppManager app;

    @BeforeMethod
    public void setUp() {
        app = new AppManager("chrome");
        app.init();
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        User user = new User()
                .setFirstName(UserData.First_Name)
                .setLastName(UserData.Last_Name)
                .setEmail(UserData.Email)
                .setPassword(UserData.Password)
                .setConfirmPassword(UserData.Confirm_Password);

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isUserLoggedIn(), "User did not log in after registration");
           }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}

