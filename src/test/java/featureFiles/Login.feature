@tag
Feature: Login
  Background:
    Given I landed on Jotform Page

  @Regression
  Scenario Outline: Login successfully
    Given Click signin button
    And Log in with userName <userName> and password <password>
    When Click login button
    Then MyForms button is displayed on HomePage

    Examples:
    |userName               | password |
    |muberrakurt5@gmail.com | Kelebe1.|