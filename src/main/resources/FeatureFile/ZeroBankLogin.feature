Feature: Login Functionality

  Background: navigate to website
    Given User navigate to website


  Scenario Outline: Login with valid username and password
    When User enter valid "<username>" and "<password>"
    Then User should login successfully

    Examples:
      | username | password |
      | username | password |

  Scenario Outline: Login with valid username and invalid password
    When User enter valid "<username2>" and invalid "<password2>"
    Then Login should fail

    Examples:
      | username2   | password2   |
      | username    | #1234hello  |


  Scenario Outline: Login with invalid username and valid password
    When User enter invalid "<username3>" and valid "<password3>"
    Then Login should fail

    Examples:
      | username3   | password3   |
      | apple       | password    |


  Scenario Outline: Login with invalid username and invalid password
    When User enter invalid "<username4>" and invalid "<password4>"
    Then Login should fail

    Examples:
      | username4   | password4   |
      | cimbom      | chelseafc   |
