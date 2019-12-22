package step_implementations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoanPurposeTest {

    // Given the user is on the landing page
    @Given("^the user is on the landing page$")
    public void the_user_is_on_the_landing_page() {
        System.out.println("the user is on the landing page");

    }

    //When the user inputs the correct information in the text fields
    @When("^the user inputs the correct information in the text fields$")
    public void the_user_inputs_the_correct_information_in_the_text_fields() {
        System.out.println("the user inputs the correct information in the text fields");

    }

    // Then the submit button becomes clickable
    @Then("^the submit button becomes clickable$")
    public void the_submit_button_becomes_clickable() {
        System.out.println("the submit button becomes clickable");

    }
}
