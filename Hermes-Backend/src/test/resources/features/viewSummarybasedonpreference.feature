Feature: View news summary based on categorical preference

  Scenario Outline: View all the suggested articles based on the current user preference
    Given The system exists category "<category>","<type>"
    Examples:
      | category | type
      | category1 | type1
      | category2 | type2
    And The following articles "<newsID>","<category>" exist in system
    Examples:
      | newsID | category
      | news1 | category1,category2
      | news2 | category2
    And The following user "<username>","<password>","<firstname>","<lastname>","<preference>" exist in system
    Examples:
      | username | password | firstname | lastname| preference
      | user01   | code01   | first01   | last01  | category1
      | user02   | code02   | first02   | last02  | category2

    When View all article for user "<username>"
    Then the number of article summaries "<number>" for user "<username>" is correctly returned
    Examples:
      | username | number |
      | user01  | 1   |
      | user02  | 2   |

  Scenario Outline: View all suggested articles based on the current user but the user has no preference (alternative case)
    Given The system exists category "<category>","<type>"
    Examples:
      | category | type
      | category1 | type1
      | category2 | type2
    And The following articles "<newsID>","<category>" exist in system
    Examples:
      | newsID | category
      | news1 | category1,category2
      | news2 | category2
    And The following user "<username>", "<password>", "<firstname>", "<lastname>" exist in system
    Examples:
      | username | password | firstname | lastname
      | user01   | code01   | first01   | last01
      | user02   | code02   | first02   | last02

    When View all article for user "<username>"
    Then the number of article summaries "<number>" for user "<username>" is correctly returned
    Examples:
      | username | number |
      | user01   | 0   |


