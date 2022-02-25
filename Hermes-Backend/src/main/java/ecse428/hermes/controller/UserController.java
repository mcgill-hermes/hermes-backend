package ecse428.hermes.controller;


import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.service.UserAccountService;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserAccountService userAccountService;

	/**
	 * Sign up a user account.
	 *
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return a UserAccountDto with specified information.
	 * @throws Exception
	 * @author Zichen
	 */
	@PostMapping(value = {"/auth/signup", "/auth/signup/"})
	public UserAccountDto createUserAccount(@RequestBody UserAccount user) throws Exception {
		try {
			UserAccount userAccount = userAccountService.createUserAccount(user.getUserName(), user.getPassword(), 
					user.getFirstName(), user.getLastName());
			return ControllerHelper.convertToDto(userAccount);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	
	/**
	 * login a user.
	 *
	 * @param userName
	 * @param password
	 * @return UserAccountDto if password match with userName
	 * @throws Exception
	 * @author Zichen
	 */
	@PostMapping(value = {"/auth/login", "/auth/login/"})
	public UserAccountDto accountLogin(@RequestBody UserAccount user) throws Exception {
		try {
			UserAccount userAccount = userAccountService.verifyUserAccountPassword(user.getUserName(), user.getPassword());
			return ControllerHelper.convertToDto(userAccount);
		} catch (RuntimeException e) {
				throw new RuntimeException(e.getMessage());
		}
	}


	/*********************************************************
	 * Jiatong Niu's workspace
	 *********************************************************/

	/**
	 * @return an UserAccountDto
	 * @throws Exception
	 * @author Jiatong Niu
	 * @para userName
	 */

	@GetMapping(value = {"/getAccountByUsername", "/getAccountByUsername/"})
	public UserAccountDto getAccountByUsername(@RequestParam String userName) throws Exception {
		try {
			UserAccount userAccount = userAccountService.getAccountByUsername(userName);
			return ControllerHelper.convertToDto(userAccount);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	/**
	 * @param username
	 * @param originalpassword
	 * @param newpassword
	 * @param newfirstname
	 * @param newlastname
	 * @return an UserAccountDto
	 * @throws Exception
	 * @author Jiatong Niu
	 */
	@PostMapping(value = {"/myaccount/editinformation", "/myaccount/editinformation/"})
	public UserAccountDto updateGeneralInformation(@RequestParam String originalpassword,
		@RequestBody UserAccount newUser) throws Exception {
		try {
			UserAccount userAccount = userAccountService.updateAccountInfo(newUser.getUserName(), originalpassword, 
					newUser.getPassword(), newUser.getFirstName(), newUser.getLastName());
			return ControllerHelper.convertToDto(userAccount);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	/**
	 * @return
	 * @author Jiatong Niu
	 */
	@GetMapping(value = {"/news/get-all", "/news/get-all/"})
	public List<ArticleDto> getAllArticles() {
		List<Article> articles = userAccountService.getAllArticles();
		return articles.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());
	}

	/**
	 * @param username
	 * @return
	 * @throws Exception
	 * @author Jiatong Niu
	 */
	@GetMapping(value = {"/news/foruser/", "news/foruser/"})
	public List<ArticleDto> getNewsForUser(@RequestBody String username) throws Exception {
		try {
			UserAccount userAccount = userAccountService.getAccountByUsername(username);
			List<Article> articlesForUser = userAccountService.getArticlesByUser(userAccount);
			return articlesForUser.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());

		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Return news in that category.
	 * @param type
	 * @return
	 * @throws Exception
	 * @author Jiatong Niu
	 */
	@GetMapping(value = {"/news/Category/", "news/Category/"})
	public List<ArticleDto> getNewsOfType(@RequestParam String type) throws Exception {
		try {
			Category category = userAccountService.getCategoryByType(type);
			List<Article> articlesOfCategory = userAccountService.getArticlesOfCategory(category);
			return articlesOfCategory.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Return news in that category and filter out the ones the user already seen.
	 * @param type
	 * @param username
	 * @return
	 * @throws Exception
	 * @author Jiatong Niu
	 */
	@GetMapping(value = {"news/Category/forUser", "news/Category/forUser/"})
	public List<ArticleDto> getNewsOfTypeForUser(@RequestParam String type, @RequestParam String username) throws Exception{
		try{
			UserAccount userAccount = userAccountService.getAccountByUsername(username);
			Category category = userAccountService.getCategoryByType(type);
			List<Article> articlesOfCatForUser = userAccountService.getArticlesOfCategoryForUser(category,userAccount);
			return articlesOfCatForUser.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());

		}catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	
	/*********************************************************
	 * Templates
	 *********************************************************/
	

	/**
	 * Input a Json file
	 * Todo: check login status
	 * @param userAccount
	 * @return
	 */

	/* Example of Json

	{
    "userName": "eclipse",
 	"password": "ditto",
    "firstName": "chen",
    "lastName": "kua"
	}

	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestBody UserAccount userAccount){

		return userAccount.getUserName() + userAccount.getPassword();

	}
	
//	public String logout (String username, String password) {
//		String status = "login";
//		userAccountService.verifyUserAccountPassword(username, password);
//		status = "logout";
//		return status;
//	}

}