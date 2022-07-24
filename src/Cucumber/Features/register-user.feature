Feature: Register user

  Scenario Outline: System is able to register new user
    Given unregistered user is on home page
    When user clicks on sign in button
    And provides new email address
    And fills form with <firstName> <lastName> <password>
    Then new user is created
    Examples:
      | firstName | lastName  | password  |
      | Adam      | Słodowy   | password1 |
      | Tomasz    | Kucharski | 1235151   |
      | Dariusz   | Zieliński | dsdsadap  |