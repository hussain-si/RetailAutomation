Feature: Search functionality for an e-commerce platform

  Background: User is logged into the application

    Given User is logged into the application

    @smoke @search
    Scenario: Searching the product
      When user searches for an item "shoe"
      Then The title of the search result should be dislayed
      And User opens the size chart of shoe
      And User closes the size chart
