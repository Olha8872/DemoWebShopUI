package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartHelper extends BaseHelper {

    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void addSecondItemToCart() {
        click(By.cssSelector("div.product-item:nth-child(2) .add-to-cart-button"));
    }
        public boolean isItemAddedToCart(String confirmationMessage) {
        return isElementPresent(By.xpath("//div[@class='bar-notification success']//*[contains(text(), '" + confirmationMessage + "')]"));
    }

      public String getItemQuantity() {
        WebElement qtyInput = driver.findElement(By.cssSelector("input.qty-input"));
        return qtyInput.getAttribute("value");
    }

    public String getItemName() {
        WebElement itemName = driver.findElement(By.cssSelector("td.product-name a"));
        return itemName.getText();
    }

    public String getItemPrice() {
        WebElement itemPrice = driver.findElement(By.cssSelector("td.product-unit-price span.price"));
        return itemPrice.getText();
    }

    public String getItemSubtotal() {
        WebElement itemSubtotal = driver.findElement(By.cssSelector("td.product-subtotal span.price"));
        return itemSubtotal.getText();
    }

    public void clearCart() {
    }

    public void addItemToCart(String itemName) {
    }
}
