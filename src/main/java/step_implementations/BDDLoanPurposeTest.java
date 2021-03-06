package step_implementations;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BDDLoanPurposeTest {
    protected WebDriver driver;
    private static final String COMMON_RADIOBUTTON_PATTERN = "//span[text() = '%s']";
    private static final String ANNUAL_INCOME_INPUT = "//input[@name='employment.incomeYearly']";
    private static final String FIRST_NAME_FIELD = "//input[@placeholder='First name']";
    private static final String LAST_NAME_FIELD = "//input[@placeholder='Last name']";
    private static final String DOB_FIELD = "//input[@placeholder = 'Date of birth (MM/DD/YYYY)']";
    private static final String ADDRESS_FIELD = "//input[@placeholder='Address']";
    private static final String PATTERN_ADDRESS = "b.geosuggest__item__matched-text";
    private static final String CONTINUE_BUTTON = "//button[text()= 'Continue']";
    private static final String HOUSING_PAYMENT_FIELD = "//input[@placeholder='Monthly housing payment']";
    private static final String SSN_FIELD = "//input[@placeholder='Social security number']";
    private static final String PHONE_NUMBER_FIELD = "//input[@placeholder='Phone number']";
    private static final String EMAIL_FIELD = "//input[@placeholder='Email']";
    private static final String PASSWORD_FIELD = "//input[@placeholder='Password']";
    private static final String SUBMIT_BUTTON = "//button[@type = 'submit']";
    private static final String ZIP = ".//*[text() = 'ZIP code']";


    @Given("^the user is on the landing page$")
    public void the_user_is_on_the_landing_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.credible.com/?vt_disabled=true");

    }

    @When("^the user navigates to Loan purpose page$")
    public void the_user_navigates_to_Loan_purpose_page() {
        driver.findElement(By.xpath("//*[@data-test-id='product-card-PL']//button")).click();
        driver.findElement(By.xpath("//*[contains(@placeholder, 'Enter amount')]")).sendKeys("10000");
        driver.findElement(By.xpath("//button[text() = 'Find My Rate']")).click();
    }

    @And("^the user chooses loan purpose$")
    public void the_user_chooses_loan_purpose() throws InterruptedException {
        String loanPurpose = "Debt consolidation";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, loanPurpose))).click();
    }

    @And("^the user chooses education level$")
    public void the_user_chooses_education_level() throws InterruptedException {
        String educationLevel = "High school";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, educationLevel))).click();
    }

    @And("^the user chooses loan purpose (.*)$")
    public void user_chooses_loan_purpose(String loanPurpose) throws InterruptedException {
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, loanPurpose))).click();
    }


    @And("^the user chooses education level(.*)$")
    public void user_chooses_education_level(String educationLevel) throws InterruptedException {
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, educationLevel))).click();

    }

    @And("^the user chooses Employment Status$")
    public void the_user_chooses_Employment_Status() throws InterruptedException {
        String employmentStatus = "Full-time employed";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, employmentStatus))).click();
    }

    @And("^the user chooses Income level$")
    public void the_user_chooses_Income_level() throws InterruptedException {
        String incomeLevel = "50000";
        driver.findElement(By.xpath(ANNUAL_INCOME_INPUT)).sendKeys(incomeLevel);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();
    }

    @And("^the user chooses Credit Score$")
    public void the_user_chooses_Credit_Score() throws InterruptedException {
        String creditScore = "Excellent (750+)";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, creditScore))).click();
    }

    @And("^the user enters Personal Info$")
    public void the_user_enters_Personal_Info() throws InterruptedException {
        String firstName = "Alex";
        String lastName = "Somov";
        driver.findElement(By.xpath(FIRST_NAME_FIELD)).sendKeys(firstName);
        driver.findElement(By.xpath(LAST_NAME_FIELD)).sendKeys(lastName);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();

    }

    @And("^the user enters Date Of Birth$")
    public void the_user_enters_Date_Of_Birth() throws InterruptedException {
        driver.findElement(By.xpath(DOB_FIELD)).sendKeys("12181986");
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();

    }

    @And("^the user enters Address$")
    public void the_user_enters_Address() throws InterruptedException {
        String streetPartialName = "2715 Cabrillo Street, San Francisco";
        driver.findElement(By.xpath(ADDRESS_FIELD)).sendKeys(streetPartialName);
        driver.findElement(By.cssSelector(PATTERN_ADDRESS)).click();
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();
    }

    @And("^the user chooses Housing Status$")
    public void the_user_chooses_Housing_Status() throws InterruptedException {
        String housingStatus = "Rent";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, housingStatus))).click();
    }

    @And("^the user enters Monthly Housing Payment$")
    public void the_user_enters_Monthly_Housing_Payment() throws InterruptedException {
        String housePayment = "1000";
        driver.findElement(By.xpath(HOUSING_PAYMENT_FIELD)).sendKeys(housePayment);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();

    }

    @And("^the user chooses Citizenship Status$")
    public void the_user_chooses_Citizenship_Status() throws InterruptedException {
        String citizenshipStatus = "Yes";
        driver.findElement(By.xpath(String.format(COMMON_RADIOBUTTON_PATTERN, citizenshipStatus))).click();
    }

    @And("^the user enters SSN$")
    public void the_user_enters_SSN() throws InterruptedException {
        String ssn = "134234565";
        driver.findElement(By.xpath(SSN_FIELD)).sendKeys(ssn);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();
    }

    @And("^the user enters Phone Number$")
    public void the_user_enters_Phone_Number() throws InterruptedException {
        String phoneNum = "1223234565";
        driver.findElement(By.xpath(PHONE_NUMBER_FIELD)).sendKeys(phoneNum);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();
    }

    @And("^the user enters Email$")
    public void the_user_enters_Email() throws InterruptedException {
        String email = "dfd@kp.org";
        driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(email);
        driver.findElement(By.xpath(CONTINUE_BUTTON)).click();
    }

    @And("^the user enters Password$")
    public void the_user_enters_Password() throws InterruptedException {
        String password = "dfdfads";
        driver.findElement(By.xpath(PASSWORD_FIELD)).sendKeys(password);
    }

    @Then("^the submit button becomes clickable$")
    public void the_submit_button_becomes_clickable() {
        WebElement button = driver.findElement(By.xpath(SUBMIT_BUTTON));
        Assert.assertTrue(button.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
