package stepDefinition;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import ecse428.hermes.controller.UserController;
import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.service.UserAccountService;

import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.service.UserAccountService;

public class CucumberStepDefinition {
	
	private UserAccountService userAccountService;
	private UserAccount userAccount;
	
	/**
	 * feature: User Login (normal case)
	 * @param username: string1
	 * @param password: string2
	 * @param firstname: string3
	 * @param lastname: string4
	 * @author Yujing Yang 
	 */
	
	@Given("the system exist the account {string}, {string}, {string}, {string}")
	public void the_system_exist_the_account(String string1, String string2, String string3, String string4) {
		userAccount = userAccountService.createUserAccount(string1, string2, string3, string4);
	}

	@Given("the user is not logged in with username {string} and password {string}")
	public void the_user_is_not_logged_in_with_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
		// UserAccount userAccount = userAccountService.getAccountByUsername(string);
		
	}
	
	@When("the user login to the website")
	public void the_user_login_to_the_website() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
	}
	
	@Then("the user's status should be logged in")
	public void the_user_s_status_should_be_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
	}
	
	@Given("the user is logged in with username {string} and password {string}")
	public void the_user_is_logged_in_with_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	


}
