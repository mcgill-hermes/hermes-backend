Feature: Admin update summary of a article/news

  Background:
    Given the system exist the article "article01" and "article02"
    And the article "article01" has summary "summary01" and "article02" has no summary
    And the summary "summary01" has nlpResult "this is summary01"

  Scenario: Admin update the summary of a article successfully (normal case)
    When the admin update "summary01" with the new nlpResult "update summary01"
    Then the "summary01" has the updated nlpResult "update summary01"

  Scenario: Admin tries to update the summary of an article but the article does not have summary (alternative case)
    When the admin updates the summary of "article02"
    Then display an error message "Error: this article does not have summary" to the Admin
