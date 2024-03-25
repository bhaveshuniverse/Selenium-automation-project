Feature: Buying a product from amazon website

  @TSC002
  Scenario: user logins into amazon
    Given user opens an amazon website
    When user fills the username and password
    And user logins into the amazon website
    Then user validates that login is successful

  @TSC003
  Scenario: user adds the product to his amazon cart
    Given user search for the product in amazon website
    When user selects a particular product
    And user chooses a particular specification
    Then user adds that product to amazon cart

  @TSC004
  Scenario: user proceeds to checkout the product present in the cart
    Given user opens the mycart
    When user increases the quantity
    And user moves into checkout page
    Then user validates for the checkout page