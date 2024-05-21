Feature: Register Functionality of Open E-Cart
  As a new user of the Open E-Cart
  I should be able to create new account
  by passing valid credentials
  Background:
    Given I am on the register page

  Scenario: Successful registration with valid credentials
    Given I have entered valid credentials for registration
    When I click on register button
    Then I should be registered successfully