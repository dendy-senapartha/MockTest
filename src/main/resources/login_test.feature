Feature: feature to test login functionality
  Scenario: Check login with valid credentials
    Given browser opened
    And user in login page
    When user insert username and password
    And login button clicked
    Then user redirect to main screen