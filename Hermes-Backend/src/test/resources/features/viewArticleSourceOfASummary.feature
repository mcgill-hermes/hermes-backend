Feature: View the article source of a summary

  Scenario Outline: View article source of a summary successfully
    Given The system exists summaries "<summary>","<nlpResult>"
    Examples:
      | summary | nlpResult
      | summary1 | nlpResult1
      | summary2 | nlpResult2
      | summary3 | nlpResult3

    And The following articles "<article>","<url>" exist in system
    Examples:
      | article | url
      | article1 | url1
      | article2 | url2
      | article3 | url3
      | article4 | url4

    When View the article source of a summary
    Then the article "<article>" for each summary "<summary>" is correctly returned
    Examples:
      | article   | summary  |
      | article1  | summary1 |
      | article2  | summary2 |
      | article3  | summary3 |

  Scenario Outline: View the articles source of a summary but some articles do not have a summary (alternative case)
    Given The system exists summaries "<summary>","<nlpResult>"
    Examples:
      | summary | nlpResult
      | summary1 | nlpResult1
      | summary2 | nlpResult2
      | summary3 | nlpResult3

    And The following articles "<article>","<url>" exist in system
    Examples:
      | article | url
      | article1 | url1
      | article2 | url2
      | article3 | url3
      | article4 | url4


    When View the article source of a summary
    Then the article "<article>" for each summary "<summary>" is correctly returned but some articles do not have summary
    Examples:
      | article   | summary  |
      | article1  | summary1 |
      | article2  | summary2 |
      | article3  | summary3 |
      | article4  | null |


