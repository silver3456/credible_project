package com.usa.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    private static final String PERSONAL_LOAN_TILE = "//*[@data-test-id='product-card-PL']//button";
    private static final String AMOUNT_INPUT_FIELD = "//*[contains(@placeholder, 'Enter amount')]";
    private static final String FIND_MYRATE_BUTTON = "//button[text() = 'Find My Rate']";


    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open main page with url : {0}")
    public LandingPage open(String url) {
        LOG.info("Open with url: " + url);
        driver.get(url);
        return this;
    }

    @Step("Go to Loan purpose page")
    public void goToLoanPurposePage(String moneyAmount) {
        LOG.info("Navigate to Loan purpose page");
        helper.clickOnElement(PERSONAL_LOAN_TILE);
        helper.enterText(AMOUNT_INPUT_FIELD, moneyAmount );
        helper.clickOnElement(FIND_MYRATE_BUTTON);
        helper.waitPageLoaded();
    }
}
