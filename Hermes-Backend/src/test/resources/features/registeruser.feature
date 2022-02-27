Feature: User Registration


  Scenario Outline: Create a new user account
    Given that user want to open a new account 
  	When the user register the account with "<username>", "<password>", "<firsname>", "<lastname>"
  	Then the new user is created in the database
  	
    Examples:
      | username | password | firstname | lastname
      | user01   | code01   | first01   | last01
      | user02   | code02   | first02   | last02
	      
	      
  Scenario Outline: Create a new user account with an unproper input(Error Flow)
	  Given the system exist the account 
    When the user register the account with "<username>", "<password>", "<firsname>", "<lastname>"
  	Then the backend should return error message "<error>"
  	
    Examples:
      | username | password | firstname | lastname| error                  |
      | user01   |          | first01   | last01  |ERROR: Invalid password |
      | user02   | code02   | first02   |         |ERROR: Invalid lastName |