Feature: Find All Expenses
  Scenario: get All Expenses
    Given there are some expenses in the list
    When I search for expenses with name started with "test"
    Then List with 1 expense should be returned