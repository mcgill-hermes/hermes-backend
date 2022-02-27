Feature: View news summary based on categorical preference

  Scenario Outline: View all the suggested articles based on the current user preference
    Given The system exists category "<category>"
    And The following articles "<newsID>","<category>" exist in system
    And the system exist the account "<username>", "<password>", "<firstname>", "<lastname>","<history>"
    When View all article for user "<username>"
    Then the number of article summaries "<number>" for user "<username>" is correctly returned
    Examples:
      | username | password | firstname | lastname| category  | newsID  | number | history
      | user01   | code01   | first01   | last01  | category1 | news1   | 1      | null
      | user02   | code02   | first02   | last02  | category2 | news2   | 2      | null

  Scenario Outline: View all suggested articles based on the current user but the user has no preference (alternative case)
    Given The system exists category "<category>"
    And The following articles "<newsID>","<category>" exist in system
    And the system exist the account "<username>", "<password>", "<firstname>", "<lastname>","<history>"
    When View all article for user "<username>"
    Then the number of article summaries "<number>" for user "<username>" is correctly returned
    Examples:
      | username | password | firstname | lastname| category  | newsID  | number | history
      | user01   | code01   | first01   | last01  | category1 | news1   | 0      | null
