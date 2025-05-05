package com.demowebshop.tests;

import com.demowebshop.models.User;
import com.demowebshop.data.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        User user = new User()
                .setFirstName(UserData.First_Name)
                .setLastName(UserData.Last_Name)
                .setEmail(UserData.Email)
                .setPassword(UserData.Password)
                .setConfirmPassword(UserData.Confirm_Password);


        app.getUser().register(user);

        Assert.assertTrue(app.getUser().isUserLoggedIn(), "User is not logged in after registration");
    }
}
