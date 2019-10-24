package com.usa.web.pages;

import com.usa.web.utils.ElementHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected ElementHelper helper;
    protected Logger LOG;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
        LOG = Logger.getLogger(this.getClass().getName());
    }
}
