Feature: User delete a news category as user preference

  Background:
    Given the system exist the account "user01", "code01", "first01", "last01"
    And the user is logged in with username "user01" and password "code01"
    And the system exist the category "category01"
    And the system exist the category "category02"
    And the preference of the user with username "user01" has category "category01"

  Scenario Outline: Delete an existing news category as user preference (normal case)
    When the user with username "user01" delete the category "category01" as user preference
    Then the preference of the user with username "user01" has no category "category01"
    Examples:
      |  |

  Scenario Outline: Delete a none existed news category as user preference (alternative case)
    Given the preference of the user with username "user01" has no category "category02"
    When the user with username "user01" delete the category "category02" as user preference
    Then the preference of the user with username "user01" has category "category01"
    But the preference of the user with username "user01" has no category "category02"
    Examples:
      |  |