package stepDefinition;

import ecse428.hermes.model.Category;
import ecse428.hermes.service.CategoryService;
import io.cucumber.java.en.*;

import ecse428.hermes.model.UserAccount;
import ecse428.hermes.service.UserAccountService;


import java.util.List;

public class CucumberStepDefinition {

	private UserAccountService userAccountService;
	private CategoryService categoryService;
	
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
	public void the_system_exist_the_account(String username, String password, String firstname, String lastname) {
		//userAccount = userAccountService.createUserAccount(username, password, firstname, lastname);
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
	

	@Given("the system exist the category {string}")
	public void theSystemExistTheCategory(String arg0) {
		//userAccountService.getCategoryByType(arg0);
	}

	@Given("the preference of the user with username {string} has no category {string}")
	public void thePreferenceOfTheUserWithUsernameHasNoCategory(String arg0, String arg1) {
//		UserAccount userAccount = userAccountService.getAccountByUsername(arg0);
//		List<Category> categoryList = userAccount.getPreference();
//		categoryList.removeIf(category -> category.getType().equals(arg1));
//		userAccount.setPreference(categoryList);
	}

	@Given("the preference of the user with username {string} has category {string}")
	public void thePreferenceOfTheUserWithUsernameHasCategory(String arg0, String arg1) {
//		UserAccount userAccount = userAccountService.getAccountByUsername(arg0);
//		Category category1 = categoryService.createCategory(arg1);
//		List<Category> categoryList = userAccount.getPreference();
//		categoryList.removeIf(category -> category.getType().equals(arg1));
//		categoryList.add(category1);
//		userAccount.setPreference(categoryList);
	}

	@Then("the preference of the user with username {string} now has category {string}")
	public void thePreferenceOfTheUserWithUsernameNowHasCategory(String arg0, String arg1) {
//		UserAccount userAccount = userAccountService.getAccountByUsername(arg0);
//		for (Category category : userAccount.getPreference()){
//			if (category.getType().equals(arg1)) return;
//		}
//		throw new IllegalArgumentException("User "+arg0+" does not has category "+arg1+" as preference.");
	}

	@Then("the preference of the user with username {string} now has no category {string}")
	public void thePreferenceOfTheUserWithUsernameNowHasNoCategory(String arg0, String arg1) {
//		UserAccount userAccount = userAccountService.getAccountByUsername(arg0);
//		for (Category category : userAccount.getPreference()){
//			if (category.getType().equals(arg1))
//				throw new IllegalArgumentException("User "+arg0+" has category "+arg1+" as preference.");
//		}
	}

	@When("the user with username {string} select the category {string} as user preference")
	public void theUserWithUsernameSelectTheCategoryAsUserPreference(String arg0, String arg1) {
	}

	@When("the user with username {string} update the category {string} as user preference")
	public void theUserWithUsernameUpdateTheCategoryAsUserPreference(String arg0, String arg1) {
	}

	@When("the user with username {string} delete the category {string} as user preference")
	public void theUserWithUsernameDeleteTheCategoryAsUserPreference(String arg0, String arg1) {
	}
}
