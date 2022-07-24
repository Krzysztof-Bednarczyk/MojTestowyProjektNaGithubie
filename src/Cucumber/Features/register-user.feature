Feature: Register user
  Scenario: System is able to register new user
    Given unregistered user is on home page
    When user clicks on sign in button
    And provides new email address
    And fills form with Adam Słodowy password1
    Then new user is created