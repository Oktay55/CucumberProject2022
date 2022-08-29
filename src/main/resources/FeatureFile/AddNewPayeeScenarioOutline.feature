Feature: Add new Payee Functionality

  Background:
    Given User navigate to Bank app
    And User login to the bank account
    And User click online banking on the homepage
    When User click on pay bills and click on add new payee


  Scenario Outline: Add new payee
    Then User should be able to fill out "<name>", "<address>", "<account>", "<details>" and add new payee
    And User should see success message

    Examples:
      | name      | address              | account      | details |
      | Sergio    | 55 chelsea drive     | 1234567      | money   |

  Scenario Outline: Add new payee
    Then User should be able to fill out "<name>", "<address>", "<account>", "<details>" and add new payee
    And User should see error message: Please fill out this field.

    Examples:
      | name      | address              | account      | details |
      |           | 55 chelsea drive     | 1234567      | money   |
      | name      |                      | 1234567      | details |
      | name      | 55 chelsea drive     |              | money   |

