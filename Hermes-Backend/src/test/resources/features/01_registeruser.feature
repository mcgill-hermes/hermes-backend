Feature: User Registration


  Scenario Outline: Create a new user account (normal flow)
    Given the system does not exist the account "<username>", "<password>", "<firstname>", "<lastname>"
  	When the user register the account with "<username>", "<password>", "<firstname>", "<lastname>"
  	Then the system exist the account "<username>", "<password>", "<firstname>", "<lastname>"
    Examples:
      | username | password | firstname | lastname
      | user01   | code01   | first01   | last01
      | user02   | code02   | first02   | last02
	      
	      
  Scenario Outline: Create a new user account with an improper input(error flow)
    Given the system does not exist the account "<username>", "<password>", "<firstname>", "<lastname>"
    When the user register the account with "<username>", "<password>", "<firstname>", "<lastname>"
  	Then the backend should return error message "<error>"
  	
    Examples:
      | username | password | firstname | lastname| error                   |
      | user01   | null     | first01   | last01  | ERROR: Invalid password |
      | user02   | code02   | first02   | null    | ERROR: Invalid lastName |