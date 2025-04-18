package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @Test
    public void addSecondItemToCartPositiveTest() {
        String email = "sitiuk+" + System.currentTimeMillis() + "@gmail.com";

        User user = new User()
                .setEmail(email)
                .setPassword("Qwerty123@");

        // registration
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistration();

        // add 2nd item
        app.getCart().addSecondItemToCart();

        // verify
        Assert.assertTrue(app.getCart().isItemAddedToCart("has been added to your shopping cart"));


    }
}
