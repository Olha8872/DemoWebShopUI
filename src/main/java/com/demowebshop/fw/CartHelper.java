package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartHelper extends BaseHelper {
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void addSecondItemToCart() {
        driver.get("http://demowebshop.tricentis.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondAddToCartBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//input[@value='Add to cart'])[2]")));
        secondAddToCartBtn.click();
    }

    // qwantity in cart
    public boolean isItemCountCorrect(int expectedItemCount) {
        String itemCountText = driver.findElement(By.xpath("//span[@class='cart-qty']")).getText();
        itemCountText = itemCountText.replaceAll("[^0-9]", "");  //Non-digit characters are removed from the string
        int itemCount = Integer.parseInt(itemCountText);
        return itemCount == expectedItemCount;
    }

    public boolean isItemAddedToCart(String message) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // waiting for success message
            WebElement successMsg = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.cssSelector(".bar-notification.success .content")));

            // The message is checked
            return successMsg.getText().contains(message);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return false;
        }
    }

    // Qwantity in Item
           public String getItemQuantity() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='itemquantity5289935']")));
            return driver.findElement(By.xpath("//input[@name='itemquantity5289935']")).getAttribute("value");
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    // getting item name
    public String getItemName() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-name']")));
            return driver.findElement(By.xpath("//a[@class='product-name']")).getText();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    // getting item price
    public String getItemPrice() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='product-unit-price']")));
            return driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }

    // getting item subtotal
    public String getItemSubtotal() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='product-subtotal']")));
            return driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            return null;
        }
    }
}
