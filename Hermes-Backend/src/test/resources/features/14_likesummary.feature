Feature: User likes a news summary

  Background:
    Given the system exist the account "user01", "code01", "first01", "last01"
    And the user is logged in with username "user01" and password "code01"
    And the system exist the news summary with id "1"

  Scenario Outline: User likes a news summary (normal case)
    Given the like count of the news summary with id "<summaryid>" is 0
    When the user with username "<username>" likes news summary with id "<summaryid>"
    Then the like count of the news summary with id "<summaryid>" becomes 1
    Examples:
      | username  | summaryid
      | user01    | 1

  Scenario Outline: User likes a news summary that is liked before (alternative case)
    Given the like count of the news summary with id "<summaryid>" is liked by user with username "<username>"
    When the user with username "<username>" likes news summary with id "<summaryid>"
    Then the like count of the news summary with id "<summaryid>" becomes 1
    Examples:
      | username  | summaryid
      | user01    | 1