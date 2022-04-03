Feature: Admin deletes category to a user

  Background:
    Given the system exist the account "user01", "code01", "first01", "last01"
    And the system exist the category "category01"
    And the system exist the category "category02"
    And the preference of the user with username "user01" has category "category01"

  Scenario Outline: Admin deletes a existing category from a user preference (normal case)
    When Admin deletes the the category "<category1>"  from user with username "<username>"
    Then the preference of the user with username "<username>" now has no category "<category1>"
    Examples:
      | username  | category1
      | user01    | category01

  Scenario Outline: Admin deletes a non-existing category from a user preference (alternative case)
    Given the preference of the user with username "<username>" has no category "<category2>"
    When Admin deletes the the category "<category2>"  from user with username "<username>"
    Then the preference of the user with username "<username>" now has category "<category1>"
    But the preference of the user with username "<username>" now has no category "<category2>"
    Examples:
      | username  | category1   | category2
      | user01    | category01  | category02

