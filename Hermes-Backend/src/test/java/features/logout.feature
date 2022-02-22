Feature: User Logout

  Background: 
  	Given the website is running

  Scenario Outline: Logout to change a user (normal case)
  	Given the user is logged in with username "<username>" and password "<password>"
  	When the user logout from the website
  	Then the user's status should be logged out
  	And the user should not be able to browse the website content
	  Examples:
		  | username | password
	      | user01   | code01
	      | user02   | code02
	Scenario Outline: Logout to change a user (alternative case)
  	Given the user with username "<username>" and password "<password>" is not logged in
  	When the user logout from the website
  	Then the user cannot logout successfully
  	And the user's status should be logged out
  	And the user should not be able to browse the website content
		Examples:
			| username | password
			| user01   | code01
			| user02   | code02