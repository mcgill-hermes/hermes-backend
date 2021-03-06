Feature: User update a news category as user preference

  Background:
    Given the system exist the account "user01", "code01", "first01", "last01"
    And the user is logged in with username "user01" and password "code01"
    And the system exist the category "category01"
    And the system exist the category "category02"
    And the preference of the user with username "user01" has category "category01"

  Scenario Outline: Update a news category as user preference (normal case)
    Given the preference of the user with username "<username>" has no category "<category2>"
    When the user with username "<username>" update the category "<category2>" as user preference
    Then the preference of the user with username "<username>" now has category "<category2>"
    But the preference of the user with username "<username>" now has no category "<category1>"
    Examples:
      | username  | category1   | category2
      | user01    | category01  | category02

  Scenario Outline: Update an existing news category as user preference (alternative case)
    Given the preference of the user with username "<username>" has category "<category2>"
    When the user with username "<username>" update the category "<category2>" as user preference
    Then the preference of the user with username "<username>" now has category "<category2>"
    But the preference of the user with username "<username>" now has no category "<category1>"
    Examples:
      | username  | category1   | category2
      | user01    | category01  | category02