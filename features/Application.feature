#Each feature file contains one feature
Feature: Test filling out loan application

  #A feature may have given different specific scenarios
  #Scenarios use Given-When-Then structure
  Scenario: the user should be able to correctly fill out all the fields of the application
    Given the user is on the landing page
    When the user inputs the correct information in the text fields
    Then the submit button becomes clickable