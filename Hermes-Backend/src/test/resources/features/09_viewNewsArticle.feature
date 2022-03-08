Feature: View all News Article in a category

  Scenario Outline: View all article in a category (normal case)
    Given The following category exist in system
      | category | type
      | category1 | type1
      | category2 | type2
    And The following articles exist in system
      | newID | category |
      | news1 | category1,category2 |
      | news2 | category2           |
    When View all article in a category "<category>"
    Then the number of articles "<number>" in category "<category>" is correctly returned
    Examples:
      | category | number |
      | category1   | 1   |
      | category2   | 2   |

  Scenario Outline: View all article in a non exist category (alternative case)
    Given The following category exist in system
      | category |
      | category1 |
      | category2 |
    And The following articles exist in system
      | newID | category |
      | news1 | category1,category2 |
      | news2 | category2           |
    When View all article in a category "<category>"
    Then the number of articles "<number>" in category "<category>" is correctly returned
    Examples:
      | category | number |
      | category2   | 0   |


