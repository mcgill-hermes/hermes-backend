Feature: View the article source of a summary

  Scenario Outline: View article source of a summary successfully
    Given The system exists summaries "<summary>","<nlpResult>"
    And The following articles "<article>","<url>" exist in system
    When View the article source of a summary
    Then the article "<article>" for each summary "<summary>" is correctly returned
    Examples:
      | article   | url   | summary   | nlpResult
      | article1  | url1  | summary1  | nlpResult1
      | article2  | url2  | summary2  | nlpResult2
      | article3  | url3  | summary1  | nlpResult1
      | article4  | url4  | summary2  | nlpResult2

  Scenario Outline: View the articles source of a summary but some articles do not have a summary (alternative case)
    Given The system exists summaries "<summary>","<nlpResult>"
    And The following articles "<article>","<url>" exist in system
    When View the article source of a summary
    Then the article "<article>" for each summary "<summary>" is correctly returned but some articles do not have summary
    Examples:
      | article   | url   | summary   | nlpResult
      | article1  | url1  | summary1  | nlpResult1
      | article2  | url2  | summary2  | nlpResult2
      | article3  | url3  | summary1  | nlpResult1
      | article4  | url4  | null      | nlpResult2


