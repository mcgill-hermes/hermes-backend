Feature: User Logout

  Background: 
  	Given the website is running

  Scenario Outline: Logout to change a user (normal case)
  	Given the user is logged in
  	When the user logout from the website
  	Then the user's status should be logged out
  	And the user should not be able to browse the website content
  
  Scenario Outline: Logout to change a user (alternative case)
  	Given the user is not logged in
  	When the user logout from the website
  	Then the user cannot logout successfully
  	And the user's status should be logged out
  	And the user should not be able to browse the website content
 
