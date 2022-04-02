Feature: User searches news summary by key word

  Scenario Outline: User searches news summary by key word (normal case)
    Given The system exists keyword "<keyword>"
    And The following summary "<summaryID>" exist in system
    When User searches news summary by keyword "<keyword>"
    Then the number of article summaries "<number>" for keyword "<keyword>" is correctly returned
    Examples:
      | keyword    | summaryID  | number  |
      | keyword1   | summary1   |  1      |
      | keyword2   | summary2   |  2      |

  Scenario Outline: User searches news summary by key word (error case)
    Given The system exists keyword "<keyword>"
    And The following summary "<summaryID>" exist in system
    When User searches news summary by keyword "<keyword>"
    Then the number of article summaries "<number>" for keyword "<keyword>" is not correctly returned
    Examples:
      | keyword    | summaryID  | number  |
      | keyword1   | summary1   |  1      |
