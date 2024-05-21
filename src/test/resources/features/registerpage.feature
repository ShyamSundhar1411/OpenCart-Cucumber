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

  Scenario Outline: Unsuccessful registration with invalid or empty credentials
    Given I have entered "<firstName>", "<lastName>", "<email>", "<telephone>", "<password>", "<confirmPassword>", "<privacyAgreement>"
    When I click on register button
    Then I should see an error message

    Examples:
      | firstName | lastName | email            | telephone  | password | confirmPassword | privacyAgreement |
      |           | User     | test123@test.com | 1234567890 | test1234 | test1234        | true             |
      | Test      |          | test123@test.com | 1234567890 | test1234 | test1234        | true             |
      | Test      | User     | test123@test.com |            | test1234 | test1234        | true             |
      | Test      | User     | test123@test.com | 1234567890 |          | test1234        | true             |
      | Test      | User     | test123@test.com | 1234567890 | test1234 | differentPwd    | true             |
      | Test      | User     | test123@test.com | 1234567890 | test1234 | test1234        | false            |
