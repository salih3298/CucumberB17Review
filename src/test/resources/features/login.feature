Feature: Login Feature
  Scenario: user enters correct credentials and is able to login
    Given user navigate to the Website
    When user enters the credentials
    And click on login button
    Then the user is logged in