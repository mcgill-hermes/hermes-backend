Feature: Admin adds category to a user

  Background:
    Given the system exist the user account "user01"
    And the system exist the categories "category01", "category02", "category03", "category04"

  Scenario Outline: Admin adds a news category to a user preference (normal case)
    Given the preference of the user account "user01" has no category at beginning
    When the admin adds "<category>" to the user "user01" as user preference
    Then the preference of the user "user01" now has category "<category>"
    Examples:
      | category
      | category01
      | category02
      | category03
      | category04

  Scenario Outline: Admin adds a repeated category to a user  (alternative case)
    Given the user account "user01" already has the "<category>"
    When the admin adds "category01" to the user "user01" as preference
    Then display an error message "The category is already in the user preference" to the Admin
    Examples:
      | category
      | category01
      | category02
      | category03
      | category04
