package ecse428.hermes.service;

import ecse428.hermes.dao.ArticleRepository;
import ecse428.hermes.dao.CategoryRepository;
import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.dto.CategoryDto;
import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecse428.hermes.dao.UserAccountRepository;
import ecse428.hermes.model.UserAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepository;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;


	/**
	 * Creates a user account with the provide arguments.
	 * @param aUserName
	 * @param aPassword
	 * @param aFirstName
	 * @param aLastName
	 * @author Zichen
	 * @return the account created.
	 */
	@Transactional
	public UserAccount createUserAccount(String aUserName, String aPassword, String aFirstName, String aLastName) { 
		if (aUserName==null || aPassword==null || aFirstName==null || aLastName==null) {
			throw new IllegalArgumentException("Error: input is not complete for creating new user account.");
		}
		if (userAccountRepository.findUserAccountByUserName(String.valueOf(aUserName)) != null) {
			throw new IllegalArgumentException("ERROR: UserAccount with the provided username exists.");
		}

		UserAccount userAccount = new UserAccount();

		if (!aUserName.isEmpty()) {
			if (ServiceHelper.isValidUserName(aUserName)) {
				userAccount.setUserName(aUserName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid userName.");
			}
		} else {
			throw new IllegalArgumentException("ERROR: User name must not be empty");
		}

		if (!aPassword.isEmpty()) {
			if (ServiceHelper.isValidPassWord(aPassword)) {
				userAccount.setPassword(aPassword);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid password.");
			}
		} else {
			throw new IllegalArgumentException("ERROR: Password must not be empty");
		}

		if (!aFirstName.isEmpty()) {
			if (ServiceHelper.isValidFirstName(aFirstName)) {
				userAccount.setFirstName(aFirstName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid firstName.");
			}
		} else {
			throw new IllegalArgumentException("ERROR: First name must not be empty");
		}

		if (!aLastName.isEmpty()) {
			if (ServiceHelper.isValidLastName(aLastName)) {
				userAccount.setLastName(aLastName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid lastName.");
			}
		}

		userAccountRepository.save(userAccount);

		return userAccount;
	}

	/**
	 * Service to verify the input username with password.
	 * @param aUserName
	 * @param aPassword
	 * @author Zichen
	 * @return user if found; otherwise raise exception
	 */
	@Transactional
	public UserAccount verifyUserAccountPassword(String aUserName, String aPassword) {
		if (aUserName==null || aPassword==null) {
			throw new RuntimeException("No username or password is entered");
		}
		UserAccount user = userAccountRepository.findUserAccountByUserName(aUserName);
		if (user == null) {
			throw new RuntimeException("ERROR: no user found");
		}
		String storedPassword = user.getPassword();
		if (storedPassword.equals(aPassword)) {
			return user;
		} else {
			throw new RuntimeException("ERROR: password error");
		}
	}

	/*********************************************************
	 * Jiatong Niu's workspace
	 *********************************************************/


	/**
	 * Service to get useraccount by username(id)
	 * @param name
	 * @author Jiatong Niu
	 * @return useraccount if found; otherwise raise exception
	 */
	@Transactional
	public UserAccount getAccountByUsername(String name){
		if (name == null){
			throw new IllegalArgumentException("Error: the username is null");
		}
		UserAccount userAccount = userAccountRepository.findUserAccountByUserName(name);
		if(userAccount.equals(null)){
			throw new IllegalArgumentException("Error: the useraccount cannot be found");
		}
		return  userAccount;
	}

	/**
	 * Service to update useraccount, verify account first and check if all upddates information is null
	 * @param name
	 * @param oldPassword
	 * @param newPassword
	 * @param newFirstName
	 * @param newLastName
	 * @author Jiatong Niu
	 * @return useraccount if information updated successfully, otherwise raise exception
	 */
/*	{
	    "userName": "chang3",
	 	"password": "123456",
	    "firstName": "Zichen",
	    "lastName": "2",
	    "preference":[{
	                    "type":"military"
	                  }]
	}*/
	@Transactional
	public UserAccount updateAccountInfo (String name, String newPassword, String newFirstName, String newLastName,
			List<CategoryDto> preference){
		if (name == null){
			throw new IllegalArgumentException("Error: the username is null");
		}

		UserAccount userAccount = userAccountRepository.findUserAccountByUserName(name);
		if (userAccount.equals(null)){
			throw new IllegalArgumentException("Error: the useraccount cannot be found");
		}

//		String storedPassword = userAccount.getPassword();  Currently unused

		if (newPassword == null && newFirstName == null && newLastName== null && preference == null){
			throw new IllegalArgumentException("Error: Please update at least one information");
		} else {
			if(newPassword != null){
				userAccount.setPassword(newPassword);
			}
			if(newFirstName != null){
				userAccount.setFirstName(newFirstName);
			}
			if(newLastName != null){
				userAccount.setLastName(newLastName);
			}
		}

		if (preference != null) {
			List<Category> newPreference = new ArrayList<Category>();	// what important is the type of the categories
			List<Category> oldPreference = new ArrayList<Category>(userAccount.getPreference());			
			
			// Remove this user from all old preferences
			for (Category c: oldPreference) {
				List<UserAccount> users = new ArrayList<UserAccount>(c.getUserAccounts());	// old list of interested users
				users.remove(userAccount);
				c.setUserAccounts(users);
				categoryRepository.save(c);	
			}
			// Add new preference list and update interested users in the categories
			for (CategoryDto c : preference){
				Category category = categoryRepository.findCategoryByType(c.getType());	
				// TODO: HOPE FRONTEND WILL PROVIDE PROPER INPUT without invoking this condition line
				if (category == null) {
					throw new IllegalArgumentException("ERROR: input category " +c.getType()+" does not exist");	
				}
				// update the category user List
				List<UserAccount> ua = new ArrayList<UserAccount>(category.getUserAccounts());
				ua.add(userAccount);
				category.setUserAccounts(ua);
				categoryRepository.save(category);
				// then add this category to the preference list of user
				newPreference.add(category);
			}
			userAccount.setPreference(newPreference);
		}

		userAccountRepository.save(userAccount);
		
		return userAccount;
		//			throw new IllegalArgumentException("ERROR: password error, please enter the correct password");	
	}

	/**
	 * this method return all the articles in the system
	 * @author Jiatong Niu
	 * @return
	 */
	@Transactional
	public List<Article> getAllArticles(){
		List <Article> articles = ServiceHelper.toList(articleRepository.findAll());
		if(articles.size()>50){
			int length = articles.size();
			for(int i = 0; i <length-50;i++){
				articles.remove(0);
			}
		}
		return articles;
	}

	/**
	 * this method first find history of a user
	 * then get the user preference and find all articles that is of the type within preference (without duplication)
	 * filter out the articles that is already in history
	 * @param userAccount
	 * @author Jiatong Niu
	 * @return
	 */
	@Transactional
	public List<Article> getArticlesByUser(UserAccount userAccount){
		List<Category> userPreference = categoryRepository.findAllByUserAccounts(userAccount);
		List<Article> articles = new ArrayList<>();
		for (int i =0; i<userPreference.size();i++){
			articles.addAll(getArticlesOfCategoryForUser(userPreference.get(i),userAccount));
		}
		return articles;
	}

	/**
	 * find category with the given string that indicating type
	 * @author Jiatong Niu
	 * @param typeName
	 * @return
	 */
	@Transactional
	public Category getCategoryByType(String typeName){
		if (typeName == null){
			throw new IllegalArgumentException("Error: the typename is null");
		}
		Category type = categoryRepository.findCategoryByType(typeName);
		if(type.equals(null)){
			throw new IllegalArgumentException("Error: category not found");
		}
		return type;
	}

	/**
	 * find articles that has type of the given category
	 * @author Jiatong Niu
	 * @param category
	 * @return
	 */
	@Transactional
	public List<Article> getArticlesOfCategory(Category category){
		List<Article> articlesOfCategory = articleRepository.findAllByType(category);
		if(articlesOfCategory.equals(null)){
			throw new IllegalArgumentException("Error: No articles found");
		}
		if(articlesOfCategory.size()>50){
			int length = articlesOfCategory.size();
			for(int i = 0; i <length-50;i++){
				articlesOfCategory.remove(0);
			}
		}
		return articlesOfCategory;
	}

	@Transactional
	public List<Article> getArticlesOfCategoryForUser(Category category, UserAccount userAccount){
		List<Article> articlesOfCategory = articleRepository.findAllByType(category);
		if(articlesOfCategory.equals(null)){
			throw new IllegalArgumentException("Error: No articles found");
		}

		List<Article> history = articleRepository.findAllByUserAccounts(userAccount);
		List<Article> filteredArticles = articlesOfCategory.stream().filter(a-> !history.contains(a)).collect(Collectors.toList());
		if(filteredArticles.size()>50){
			int length = filteredArticles.size();
			for(int i = 0; i <length-50;i++){
				filteredArticles.remove(0);
			}
		}
		return filteredArticles;
	}

	/**
	 * Add a category to a user
	 * @param type
	 * @param name
	 * @return
	 * kuachen
	 */
	@Transactional
	public UserAccount addCategory(String type, String name){
		if (categoryRepository.findCategoryByType(type) == null)
			throw new IllegalArgumentException("Error: No category exists");

		if (userAccountRepository.findUserAccountByUserName(name) == null)
			throw new IllegalArgumentException("Error: No user exists");

		UserAccount user = userAccountRepository.findUserAccountByUserName(name);
		Category category = categoryRepository.findCategoryByType(type);

		List<UserAccount> userAccounts = new ArrayList<UserAccount>(category.getUserAccounts());
		List<Category> categories = new ArrayList<Category>(user.getPreference());

		if (!userAccounts.contains(user)) {
			userAccounts.add(user);
			category.setUserAccounts(userAccounts);
		} else {
			throw new IllegalArgumentException("Error: The user has already been in the category");
		}

		if (!categories.contains(category)) {
			categories.add(category);
			user.setPreference(categories);
		} else {
			throw new IllegalArgumentException("Error: The category has already been in the user");
		}

		categoryRepository.save(category);
		userAccountRepository.save(user);
		return user;
	}
//	// TODO
//	@Transactional
//	public boolean login(UserAccountDto userAccountDto){
//		return true;
//
//	}

	/**
	 * delete a category in user account
	 * @param type
	 * @param name
	 * @return
	 */
	public UserAccount deleteCategory(String type, String name){
		if (categoryRepository.findCategoryByType(type) == null)
			throw new IllegalArgumentException("Error: No category exists");

		if (userAccountRepository.findUserAccountByUserName(name) == null)
			throw new IllegalArgumentException("Error: No user exists");

		UserAccount user = userAccountRepository.findUserAccountByUserName(name);
		Category category = categoryRepository.findCategoryByType(type);

		List<UserAccount> userAccounts = new ArrayList<UserAccount>(category.getUserAccounts());
		List<Category> categories = new ArrayList<Category>(user.getPreference());

		if (userAccounts.contains(user)) {
			userAccounts.remove(user);
			category.setUserAccounts(userAccounts);
		} else {
			throw new IllegalArgumentException("Error: The user is not in the category");
		}

		if (categories.contains(category)) {
			categories.remove(category);
			user.setPreference(categories);
		} else {
			throw new IllegalArgumentException("Error: The category is not in the user");
		}

		categoryRepository.save(category);
		userAccountRepository.save(user);
		return user;

	}


}