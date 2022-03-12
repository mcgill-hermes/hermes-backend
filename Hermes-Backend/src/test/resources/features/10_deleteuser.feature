Feature: Admin deletes a user for management purpose

  Background:
    Given the system exist the account with username "user01"

  Scenario: Delete an existing user account successfully (normal case)
    When the admin delete the user with username "user01"
    Then the user "user01" cannot login anymore


  Scenario: Delete a none existed user (alternative case)
    When the admin delete the user with username "user02"
    Then the system should change nothing
    And display an error message "User does not exist" to the Admin