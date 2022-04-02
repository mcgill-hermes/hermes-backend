Feature: User switches a summary of news

  Background:
    Given the system exist the account "user01", "code01", "first01", "last01"
    And the user is logged in with username "user01" and password "code01"
    And the system exist the news summary with id "<summartid1>"
    And the system exist the news summary with id "<summartid2>"

  Scenario Outline: User switch a summary of news(normal case)
    Given the user is at the current summary with id "<summartid1>"
    When the user switch from summary with id "<summartid1>" to summary with id  "<summartid2>"
    Then the user is at the summary with id "<summartid2>"
    Examples:
      | username  | summaryid1  | summaryid2
      | user01    | 1           | 2

  Scenario Outline: User switch to a same summary of news (alternative case)
    Given the user is at the current summary with id "<summartid1>"
    When the user switch from summary with id "<summartid1>" to summary with id  "<summartid1>"
    Then the user is at the summary with id "<summartid1>"
    Examples:
      | username  | summaryid1  
      | user01    | 1          