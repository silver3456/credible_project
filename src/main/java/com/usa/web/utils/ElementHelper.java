package com.usa.web.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.usa.web.utils.PropertyLoader.getDefaultWait;
import static java.lang.String.format;

public class ElementHelper {
    private WebDriver driver;
    private static Logger LOG = Logger.getLogger(ElementHelper.class.getName());

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String locator, String text) {
        LOG.info(format("Clear and set text: %s to an element with locator: %s", text, locator));
        waitForElement(locator).clear();
        waitForElement(locator).sendKeys(text);
    }

    public void clickOnElement(String locator) {
        LOG.info("CLick on element with locator: " + locator);
        waitForElement(locator).click();
    }

    private WebElement waitForElement(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, getDefaultWait());
        return wait.until(driver -> {
            WebElement element = driver.findElement(getTypeLocator(locator));
            if (element != null && element.isDisplayed()) {
                return element;
            }

            return null;
        });
    }

    public static By getTypeLocator(String locator) {
        if (locator.startsWith("//") || locator.startsWith("/")) {
            return By.xpath(locator);
        }

        return By.cssSelector(locator);
    }

    public void waitPageLoaded() {
        new WebDriverWait(driver, getDefaultWait()).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void delay(int waitTimeInSec) {
        try {
            Thread.sleep(waitTimeInSec * 1000);
        } catch (InterruptedException e) {
            LOG.info("delay exception: " + e.getMessage());
        }
    }

    public Boolean isElementClickable(String locator) {
        WebElement element = driver.findElement(getTypeLocator(locator));
        return element != null && element.isEnabled();

    }
}
