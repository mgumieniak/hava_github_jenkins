Feature: Car
  Scenario: Return car id
    Given I have one car with id: 854203
    When the controller should find it
    Then I receive 854203 as a result