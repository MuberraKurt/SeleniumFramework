@E2e
Feature: Creating new form

  @Login
  Scenario: Login to Jotform
    Given User launches the website
    When User gives the username and password
    Then Verify logged in succesfully

  @CreateForm
  Scenario: Creating a new form
    Given User lands on the Form Builder page
    When User selects the items and add them to the form
    Then Verify the form is created