Feature: Fetch mobile phones from flipkart and store the data inside excel file
  @TSC001
  Scenario: User searches mobile phones at flipkart and saves the list into an excel file
    Given user opens the flipkart website
    When user searches the product
    Then user stores the list of products into an excel file
