package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckItemDetailsInCartTest extends TestBase {

    @Test
    public void checkItemDetailsInCart() {
        WebDriver driver = app.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement qtyInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.qty-input")));

        if (app.getCart().isItemAddedToCart("has been added to your shopping cart")) {
            String quantity = app.getCart().getItemQuantity();
            String name = app.getCart().getItemName();
            String price = app.getCart().getItemPrice();
            String subtotal = app.getCart().getItemSubtotal();

            Assert.assertNotNull(name, "Item name is null");
            Assert.assertNotNull(quantity, "Item quantity is null");
            Assert.assertNotNull(price, "Item price is null");
            Assert.assertNotNull(subtotal, "Item subtotal is null");

            System.out.println("Product: " + name);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price: " + price);
            System.out.println("Subtotal: " + subtotal);

            Assert.assertEquals(name, "14.1-inch Laptop");
            Assert.assertEquals(quantity, "2");
            Assert.assertEquals(price, "1590.00");
            Assert.assertEquals(subtotal, "3180.00");
        } else {
            Assert.fail("Item was not added to the cart.");
        }
    }
}
