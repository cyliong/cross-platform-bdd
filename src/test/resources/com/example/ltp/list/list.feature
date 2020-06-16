Feature: List
  Scenario: Add an item to the list
    Given I am on the list page
    When I add a new item "Item 1"
    Then I should see "Item 1" on the list