package com.demowebshop.tests.cart;

import com.demowebshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demowebshop.fw.CartHelper;

public class CheckItemDetailsInCartTest extends TestBase {

    @Test
    public void checkItemDetailsInCart() {
        // details of item
        String quantity = app.getCart().getItemQuantity();
        String name = app.getCart().getItemName();
        String price = app.getCart().getItemPrice();
        String subtotal = app.getCart().getItemSubtotal();

        // print details
        System.out.println("Product: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Subtotal: " + subtotal);

        //verify
        Assert.assertEquals(name, "14.1-inch Laptop");
        Assert.assertEquals(quantity, "2");
        Assert.assertEquals(price, "1590.00");
        Assert.assertEquals(subtotal, "3180.00");
    }
}
