package com.demowebshop.tests;

import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddItemToCartTests extends TestBase {

    private String lastAddedItemName;

    @BeforeMethod
    public void precondition() {

        app.getCart().clearCart();
    }

    @Test(dataProvider = "userRegistrationData", dataProviderClass = DataProviders.class)
    public void addSecondItemToCartPositiveTest(User user) {
        app.getUser().register(user);

        app.getCart().addSecondItemToCart();

        Assert.assertTrue(app.getCart().isItemAddedToCart("has been added to your shopping cart"),
                "Item was not added to cart as expected.");
    }

    @Test(dataProvider = "addItemData", dataProviderClass = DataProviders.class)
    public void addItemToCartFromDataProviderTest(String itemName) {
        app.getCart().addItemToCart(itemName);

        Assert.assertTrue(app.getCart().isItemAddedToCart("has been added to your shopping cart"),
                "Item was not added to cart as expected.");
    }

    @Test(dataProvider = "addItemWithCsv", dataProviderClass = DataProviders.class)
    public void addItemToCartFromCsvTest(String itemName) {
        app.getCart().addItemToCart(itemName);


        Assert.assertTrue(app.getCart().isItemAddedToCart("has been added to your shopping cart"),
                "Item was not added to cart as expected.");
    }

    @AfterMethod
    public void postCondition() {
        app.getCart().clearCart();
    }

      public void registerUser(WebDriver driver, User user) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ConfirmPassword")));
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));


        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getConfirmPassword());


        registerButton.click();
    }
}
