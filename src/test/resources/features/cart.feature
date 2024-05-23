Feature: Add to Cart Functionality for OpenCart E-Commerce Website
  As a user of the Opencart website
  I want to add the products to the cart
  So that I can checkout that product

  Background:
    Given I am on OpenCart login page
    When I login with my credentials
    Then I should be on home page

    Scenario: Add a product to cart
      Given I am on the view all products page
      When I add a product
      Then It should be added to cart successfully

