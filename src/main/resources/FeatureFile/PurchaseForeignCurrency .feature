Feature: Purchase Foreign Currency Functionality Test

#  Background: Login and clicking online banking on the homepage
#    Given User navigate to Zero Bank app
#    And User login to the account
#    And User go click online banking on the homepage

  Scenario Outline: Purchase Foreign Currency
    Given User navigate to Zero Bank app
    And User login to the account
    And User go click online banking on the homepage
    When User click on pay bills and click on purchase foreign currency
    Then User should select the "<currency>" they want, "<amount>", and select (USD) radio button
    And User should be able to see success message after clicking on the purchase button

    Examples:
      | currency       | amount     |
      | Mexico (peso)  | 100.00     |
