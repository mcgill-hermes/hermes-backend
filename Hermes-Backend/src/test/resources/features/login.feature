Feature: User Login


  Scenario Outline: Login as a user (normal case)
    Given the system exist the account "<username>", "<password>", "<firstname>", "<lastname>"
    And the user is not logged in with username "<username>" and password "<password>" 
    When the user login to the website
    Then the user's status should be logged in
    
    Examples:
      | username | password | firstname | lastname
      | user01   | code01   | first01   | last01
      | user02   | code02   | first02   | last02
      
  Scenario Outline: Login as a a user (alternative case)
    Given the system exist the account "<username>", "<password>", "<firstname>", "<lastname>"
    And the user is logged in with username "<username>" and password "<password>"
    When the user login to the website
    Then the user's status is not logged in
    
    Examples:
      | username | password | firstname | lastname
      | user01   | code01   | first01   | last01
      | user02   | code02   | first02   | last02