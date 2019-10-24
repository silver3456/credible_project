package com.usa.web.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoanPurposePage extends BasePage {
    private static int WAIT_TIME = 5;
    private static final String COMMON_RADIOBUTTON_PATTERN = "//span[text() = '%s']";
    private static final String ANNUAL_INCOME_INPUT = "//input[@name='employment.incomeYearly']";
    private static final String FIRST_NAME_FIELD = "//input[@placeholder='First name']";
    private static final String LAST_NAME_FIELD = "//input[@placeholder='Last name']";
    private static final String DOB_FIELD = "//input[@placeholder = 'Date of birth (MM/DD/YYYY)']";
    private static final String ADDRESS_FIELD = "//input[@placeholder='Address']";
    private static final String PATTERN_ADDRESS = "//*[@class = 'geosuggest__item__matched-text']";
    private static final String CONTINUE_BUTTON = "//button[text()= 'Continue']";
    private static final String HOUSING_PAYMENT_FIELD = "//input[@placeholder='Monthly housing payment']";
    private static final String SSN_FIELD = "//input[@placeholder='Social security number']";
    private static final String PHONE_NUMBER_FIELD = "//input[@placeholder='Phone number']";
    private static final String EMAIL_FIELD = "//input[@placeholder='Email']";
    private static final String PASSWORD_FIELD = "//input[@placeholder='Password']";
    private static final String SUBMIT_BUTTON = "//button[@type = 'submit']";

    public LoanPurposePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoanPurposePage chooseLoanPurpose(String purpose) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, purpose);
        return this;
    }

    @Step
    public LoanPurposePage chooseEducationLevel(String eduLevel) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, eduLevel);
        return this;
    }

    @Step
    public LoanPurposePage chooseIncome(String income) {
        helper.enterText(ANNUAL_INCOME_INPUT, income);
        helper.clickOnElement(CONTINUE_BUTTON);
        return this;
    }

    @Step
    public LoanPurposePage chooseCreditScore(String score) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, score);
        return this;
    }

    @Step
    public LoanPurposePage chooseEmploymentStatus(String status) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, status);
        return this;
    }

    @Step
    public LoanPurposePage enterPersonalInfo(String firstName, String lastName) {
        helper.enterText(FIRST_NAME_FIELD,firstName);
        helper.enterText(LAST_NAME_FIELD, lastName);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage enterDateOfBirth(String dateOfBirth) {
        helper.enterText(DOB_FIELD, dateOfBirth);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    private LoanPurposePage makeChoice(String locatorPattern, String value) {
        helper.clickOnElement(String.format(locatorPattern, value));
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage enterAddress(String streetPartialName) {
        helper.enterText(ADDRESS_FIELD, streetPartialName);
        driver.findElement(By.xpath((String.format(PATTERN_ADDRESS, streetPartialName)))).click();

        helper.delay(WAIT_TIME);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage chooseHousingStatus(String housingStatus) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, housingStatus);
        return this;
    }

    @Step
    public LoanPurposePage enterMonthlyHousingPayment(String payment) {
        helper.enterText(HOUSING_PAYMENT_FIELD, payment);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage chooseCitizenshipStatus(String status) {
        makeChoice(COMMON_RADIOBUTTON_PATTERN, status);
        return this;
    }

    @Step
    public LoanPurposePage enterSSN(String ssn) {
        helper.enterText(SSN_FIELD, ssn);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage enterPhoneNumber(String number) {
        helper.enterText(PHONE_NUMBER_FIELD, number);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage enterEmail(String email) {
        helper.enterText(EMAIL_FIELD, email);
        helper.clickOnElement(CONTINUE_BUTTON);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage enterPassword(String password) {
        helper.enterText(PASSWORD_FIELD, password);
        helper.waitPageLoaded();
        return this;
    }

    @Step
    public LoanPurposePage verifySubmitButtonIsClickable() {
        Assert.assertTrue(helper.isElementClickable(SUBMIT_BUTTON));
        return this;
    }
}
