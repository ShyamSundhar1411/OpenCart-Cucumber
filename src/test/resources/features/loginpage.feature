Feature: Login Functionality for OpenCart E-Commerce Website

    As a user of the OpenCart website
    I want to be able to login with my account
    So that I can access my cart and manage my orders

  Background:
    Given I am on OpenCart login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                         |
      | invalid@gmail.com | invalidPassword | Error: No match for E-mail Address and /or Password.  |
      | abc               | validPassword   | Error: MNo match for E-mail Address and /or Password. |
      | valid@gmail.com   | abc             | Error: No match for E-mail Address and /or Password.  |

  Scenario: Navigating to Forgot password page
    When I click on the "Forgotten Password" link
    Then I should be redirected to the password reset page
