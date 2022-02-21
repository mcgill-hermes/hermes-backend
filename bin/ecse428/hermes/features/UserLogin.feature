Feature: User Login

  Background:
    Given the website is running

  Scenario Outline: Login as a user (normal case)
    Given the user with username "<username>" and password "<password>" is not logged in
    When the user login to the website
    Then the user's status should be logged in
    And the user should be able to browse the website content
    Examples:
      | username | password
      | user01   | code01
      | user02   | code02

  Scenario Outline: Login as a a user (alternative case)
    Given the user is logged in with username "<username>" and password "<password>"
    When the user login to the website
    Then the user cannot login successfully
    And the user's status should be logged in
    And the user should be able to browse the website content
    Examples:
      | username | password
      | user01   | code01
      | user02   | code02