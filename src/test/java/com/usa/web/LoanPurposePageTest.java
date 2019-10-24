package com.usa.web;

import com.usa.web.utils.StringRandomGenerator;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.getBaseUrl;

public class LoanPurposePageTest extends TestRunner {
    private static final String BASE_URL = getBaseUrl();
    private String email = StringRandomGenerator.generateEmail();

    @Test
    public void testPrequalificationForm() {
        mainPage.open(BASE_URL);
        String loanAmount = "10000";
        mainPage.goToLoanPurposePage(loanAmount);

        loanPurposePage
                .chooseLoanPurpose("Debt consolidation")
                .chooseEducationLevel("High school")
                .chooseEmploymentStatus("Full-time employed")
                .chooseIncome("50000")
                .chooseCreditScore("Excellent (750+)")
                .enterPersonalInfo("Alex", "Somov")
                .enterDateOfBirth("12181986")
                .enterAddress("2715 Cabrillo Street, San Francisco")
                .chooseHousingStatus("Rent")
                .enterMonthlyHousingPayment("1000")
                .chooseCitizenshipStatus("Yes")
                .enterSSN("111111111")
                .enterPhoneNumber("4156545679")
                .enterEmail(email)
                .enterPassword("Passw0rd")
                .verifySubmitButtonIsClickable();
    }

}
