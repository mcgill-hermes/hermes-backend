package ecse428.hermes.service;

import ecse428.hermes.dao.ArticleRepository;
import ecse428.hermes.dao.CategoryRepository;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
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

		// TODO: I decide not to introduce hash code value inside the database.
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
		}
		
		if (!aPassword.isEmpty()) {
			if (ServiceHelper.isValidPassWord(aPassword)) {
				userAccount.setPassword(aPassword);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid password.");
			}
		}
		
		if (!aFirstName.isEmpty()) {
			if (ServiceHelper.isValidFirstName(aFirstName)) {
				userAccount.setFirstName(aFirstName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid firstName.");
			}
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
	@Transactional
	public UserAccount updateAccountInfo (String name, String oldPassword, String newPassword, String newFirstName, String newLastName){
		if (name == null){
			throw new IllegalArgumentException("Error: the username is null");
		}
		UserAccount userAccount = userAccountRepository.findUserAccountByUserName(name);
		if(userAccount.equals(null)){
			throw new IllegalArgumentException("Error: the useraccount cannot be found");
		}
		String storedPassword = userAccount.getPassword();

		if ((storedPassword.equals(oldPassword)) ){

			if(newPassword == null && newFirstName == null && newLastName== null){
				throw new IllegalArgumentException("Error: Please update at least one information");
			}else{
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

			userAccountRepository.save(userAccount);
			return userAccount;
		}else{
			throw new IllegalArgumentException("ERROR: password error, please enter the correct password");
		}
	}

	/**
	 * this method return all the articles in the system
	 * @return
	 */
	@Transactional
	public List<Article> getAllArticles(){
		List <Article> articles = ServiceHelper.toList(articleRepository.findAll());
		return articles;
	}

	/**
	 * this method first find history of a user
	 * then get the user preference and find all articles that is of the type within preference (without duplication)
	 * filter out the articles that is already in history
	 * @param userAccount
	 * @return
	 */
	@Transactional
	public List<Article> getArticlesByUser(UserAccount userAccount){
		List<Article> myhistory = articleRepository.findAllByUserAccounts(userAccount);
		List<Category> userPreference = categoryRepository.findAllByUserAccounts(userAccount);
		List<Article> articlesOfPreference = new ArrayList<>();
		for(int i =0; i<userPreference.size();i++){
			Category type = userPreference.get(i);
			List<Article> articlesOfType = articleRepository.findAllByType(type);

			// filter out articles that is already included when go through previous types
			List<Article> newArticles = articlesOfType.stream().filter(a-> !articlesOfPreference.contains(a)).collect(Collectors.toList());
			articlesOfPreference.addAll(newArticles);
		}

		//filter out history
		List<Article> articlesOfUser = articlesOfPreference.stream().filter(a-> !myhistory.contains(a)).collect(Collectors.toList());
		return articlesOfUser;
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
		return filteredArticles;
	}
	
}