@Home
Feature: Add to Cart Functionality for OpenCart E-Commerce Website
  As a user of the Opencart website
  I want to add the products to the cart
  So that I can checkout that product


  Scenario: Add a product to cart
    Given I am on the home page
    When I add a product to cart
    Then It should be added to cart successfully

