package com.demowebshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyListener implements WebDriverListener, MyListenerInterface {

    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

       @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        String methodName = method.getName();
        String targetException = e.getTargetException() != null ? e.getTargetException().toString() : "null";
        String targetStr = target != null ? target.toString() : "null";

        onError(methodName, targetException, targetStr);

        logger.error("An error occurred during test execution", e);
        logger.error("Method: " + methodName);
        logger.error("Target Exception: " + targetException);
        logger.error("Object Target: " + targetStr);
    }


    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Before finding element with locator: " + locator);
        beforeFindElement(locator.toString());
    }


    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Found element with locator: " + locator + " -> " + result);
        afterFindElement(locator.toString());
    }


    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        logger.info("Before finding elements with locator: " + locator);
        beforeFindElements(locator.toString());
    }


    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Found " + result.size() + " elements for locator: " + locator);
        afterFindElements(result.size());
    }


    @Override
    public void beforeClick(WebDriver driver, WebElement element) {
        logger.info("Before clicking on element: " + element);
        beforeClick(element.toString());
    }


    @Override
    public void afterClick(WebDriver driver, WebElement element) {
        logger.info("Clicked on element: " + element);
        afterClick(element.toString());
    }


    @Override
    public void beforeSendKeys(WebDriver driver, WebElement element, CharSequence... keysToSend) {
        logger.info("Before sending keys to element: " + element + " with keys: " + String.join(",", keysToSend));
        beforeSendKeys(element.toString(), String.join(",", keysToSend));
    }


    @Override
    public void afterSendKeys(WebDriver driver, WebElement element, CharSequence... keysToSend) {
        logger.info("Sent keys to element: " + element + " with keys: " + String.join(",", keysToSend));
        afterSendKeys(element.toString(), String.join(",", keysToSend));
    }


    @Override
    public void beforeFindElement(String locator) {
        logger.info("Interface log - Before finding element: " + locator);
    }

    @Override
    public void afterFindElement(String locator) {
        logger.info("Interface log - After finding element: " + locator);
    }

    @Override
    public void beforeFindElements(String locator) {
        logger.info("Interface log - Before finding elements: " + locator);
    }

    @Override
    public void afterFindElements(int size) {
        logger.info("Interface log - After finding elements, size: " + size);
    }

    @Override
    public void beforeClick(String element) {
        logger.info("Interface log - Before clicking on element: " + element);
    }

    @Override
    public void afterClick(String element) {
        logger.info("Interface log - After clicking on element: " + element);
    }

    @Override
    public void beforeSendKeys(String element, String keys) {
        logger.info("Interface log - Before sending keys to element: " + element + " with keys: " + keys);
    }

    @Override
    public void afterSendKeys(String element, String keys) {
        logger.info("Interface log - After sending keys to element: " + element + " with keys: " + keys);
    }

    @Override
    public void onError(String method, String targetException, String target) {
        logger.error("Interface log - Error occurred during method: " + method);
        logger.error("Target Exception: " + targetException);
        logger.error("Object Target: " + target);
    }
}
