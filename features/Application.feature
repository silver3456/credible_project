#Each feature file contains one feature
Feature: Test filling out loan application

  #A feature may have given different specific scenarios
  #Scenarios use Given-When-Then structure
  Scenario: the user should be able to correctly fill out all the fields of the application
    Given the user is on the landing page
    When the user navigates to Loan purpose page
    And the user chooses loan purpose
    And the user chooses education level
    And the user chooses Employment Status
    And the user chooses Income level
    And the user chooses Credit Score
    And the user enters Personal Info
    And the user enters Date Of Birth
    And the user enters Address
    And the user chooses Housing Status
    And the user enters Monthly Housing Payment
    And the user chooses Citizenship Status
    And the user enters SSN
    And the user enters Phone Number
    And the user enters Email
    And  the user enters Password
    Then the submit button becomes clickable