package com.demowebshop.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface MyListenerInterface {

    void beforeClick(WebDriver driver, WebElement element);


    void afterClick(WebDriver driver, WebElement element);


    void beforeSendKeys(WebDriver driver, WebElement element, CharSequence... keysToSend);


    void afterSendKeys(WebDriver driver, WebElement element, CharSequence... keysToSend);

    void beforeFindElement(String locator);
    void afterFindElement(String locator);
    void beforeFindElements(String locator);
    void afterFindElements(int size);
    void beforeClick(String element);
    void afterClick(String element);
    void beforeSendKeys(String element, String keys);
    void afterSendKeys(String element, String keys);
    void onError(String method, String targetException, String target);
}

