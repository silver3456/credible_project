package com.usa.web;


import com.usa.web.core.listeners.LogListener;
import com.usa.web.pages.LandingPage;
import com.usa.web.pages.LoanPurposePage;
import com.usa.web.utils.CaptureScreenshots;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import static com.usa.web.utils.PropertyLoader.getDefaultWait;


@Listeners(value = {LogListener.class})
public class TestRunner {
    protected WebDriver driver;
    protected LandingPage mainPage;
    protected LoanPurposePage loanPurposePage;

    @BeforeClass
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(getDefaultWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void initPages() {
        mainPage = new LandingPage(driver);
        loanPurposePage = new LoanPurposePage(driver);
    }

    @BeforeMethod
    public void beforeTest() {
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] tearDown(ITestResult result) {
        if (!result.isSuccess() && driver != null) {
            return CaptureScreenshots.captureScreenByte(driver);
        }

        return null;
    }

    @AfterClass
    public void afterSuiteTearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
