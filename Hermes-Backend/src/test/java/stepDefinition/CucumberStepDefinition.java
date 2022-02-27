package stepDefinition;

import ecse428.hermes.model.Category;
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
	private Category category;

	private UserAccount userRegister; 
	
	/**
	 * feature 1: register an user
	 * @author Zichen
	 */
    @Given("that user want to open a new account")
    public void user_want_to_open_a_new_account() {
		// nothing happens here really
	}
  	@When("the user register the account with {string}, {string}, {string}, {string}")
    public void user_regiter_the_acount(String userName, String password, String firstname, String lastname) {
//		 userRegister = userAccountService.createUserAccount(userName, password, firstname, lastname);
	}
  	@Then("Then the new user is created in the database")
    public void the_system_exist_the_account() {
		// check user inside the database
	}
	
	
	
	/**
	 * feature: User Login (normal case)
	 * @param username: string1
	 * @param password: string2
	 * @param firstname: string3
	 * @param lastname: string4
	 * @author Yujing Yang 
	 */
	
	// start of feature login logout
	
	@Given("the system exist the account {string}, {string}, {string}, {string}")
	public void the_system_exist_the_account(String string1, String string2, String string3, String string4) {
		//userAccount = userAccountService.createUserAccount(string1, string2, string3, string4);
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
	    // throw new io.cucumber.java.PendingException();
	}
	
	@When("the user logout from the website")
	public void the_user_logout_from_the_website() {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new io.cucumber.java.PendingException();
	}
	
	@Then("the user's status is not logged in")
	public void the_user_s_status_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    //  new io.cucumber.java.PendingException();
	}
	
	// end of feature login and logout
	

	@And("the system exist the category {string}")
	public void theSystemExistTheCategory(String arg0) {
	}

	@Given("the preference of the user with username {string} has no category {string}")
	public void thePreferenceOfTheUserWithUsernameHasNoCategory(String arg0, String arg1) {
	}

	@When("the user with username {string} select the category {string} as user preference")
	public void theUserWithUsernameSelectTheCategoryAsUserPreference(String arg0, String arg1) {
	}

	@Then("the preference of the user with username {string} has category {string}")
	public void thePreferenceOfTheUserWithUsernameHasCategory(String arg0, String arg1) {
	}

	@When("the user with username {string} update the category {string} as user preference")
	public void theUserWithUsernameUpdateTheCategoryAsUserPreference(String arg0, String arg1) {
	}

	@When("the user with username {string} delete the category {string} as user preference")
	public void theUserWithUsernameDeleteTheCategoryAsUserPreference(String arg0, String arg1) {
	}
	
	
}
