# language: en

Feature: Contact Management

  Scenario: Keeping track of contacts
    Given a user has 2 registered contacts so far
    When the user adds a new contact named "Josh"
    Then the contact list contains a contact named "Josh"
    And the contact list contains 3 entries
