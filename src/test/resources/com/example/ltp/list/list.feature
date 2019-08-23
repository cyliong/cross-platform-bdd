Feature: List
  Scenario: Add an item to the list
    Given I am on the list page
    When I add a new item
    Then I should see the new item on the list