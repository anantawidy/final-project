Feature: UI Automation Web

  @web
  Scenario: User trying to Sign Up
    Given open web test
    When user click signup
    And user input valid username signup
    And user input valid password signup
    And user click button signup
    Then user get success signup alert

  @web
  Scenario: User trying to Login
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    Then user can see name of user

  @web
  Scenario: User trying to change category product
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click category laptops
    Then user success to change the category

  @web
  Scenario: User trying to add to cart product
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click product
    And user click add to cart
    Then user get success alert

  @web
  Scenario: User trying to checkout product
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click product
    And user click add to cart
    Then user get success alert
    And user click cart
    And user click place order
    And user input placeholder
    And user click purchase
    Then user get success message to order "Thank you for your purchase!"

  @web
  Scenario: User trying to Sign Up - without fill username
    Given open web test
    When user click signup
    And user input valid password signup
    And user click button signup
    Then user get error message "Please fill out Username and Password."

  @web
  Scenario: User trying to checkout product - without fill the place order
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click product
    And user click add to cart
    Then user get success alert
    And user click cart
    And user click place order
    And user click purchase
    Then user get error message "Please fill out Name and Creditcard."

  @web
  Scenario: User trying to Login - without fill password
    Given open web test
    When user click login
    And user input valid username login
    And user click button login
    Then user get error message "Please fill out Username and Password."

  @web
  Scenario: User trying to checkout multiple product
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click product
    And user click add to cart
    Then user get success alert
    And user click home
    And user click second product
    And user click add to cart
    Then user get success alert
    And user click home
    And user click third product
    And user click add to cart
    Then user get success alert
    And user click cart
    And user click place order
    And user input placeholder
    And user click purchase
    Then user get success message to order "Thank you for your purchase!"

  @web
  Scenario: User trying to Logout
    Given open web test
    When user click login
    And user input valid username login
    And user input valid password login
    And user click button login
    And user click logout
    Then user can see button login