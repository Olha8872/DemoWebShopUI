package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        //click on login link
        click(By.cssSelector("a.ico-login"));

        //enter email
        type(By.id("Email"), "sitiuk@gmail.com");

        //enter password
        type(By.id("Password"), "Qwerty123@");

        // enter on Button Login
        click(By.name("login"));

      //verify successful login
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

}
