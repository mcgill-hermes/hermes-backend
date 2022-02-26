package ecse428.hermes.controller;

import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.dto.WebsiteDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.dto.CategoryDto;
import ecse428.hermes.dto.SummaryDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.model.Website;

public class ControllerHelper {

	/**
	 * Convert an userAccount to Dto.
	 * @param userAccount
	 * @author Zichen
	 * @return
	 */
	public static UserAccountDto convertToDto(UserAccount userAccount){
		if (userAccount == null) {
			throw new IllegalArgumentException("UserAccount does not exist.");
		}
		List<ArticleDto> services = new ArrayList<ArticleDto>();
		List<CategoryDto> preferences = new ArrayList<CategoryDto>();
		if (userAccount.getHistory() != null) {
			services = userAccount.getHistory().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}
		// TODO: the NULL problem is with this else!  -- in fact it is a forever loop in convertToDto
		// Solution: use a specific convertPreferenceToDto
		if(userAccount.getPreference() != null){ 
			preferences = userAccount.getPreference().stream().map(r -> ControllerHelper.userPreferenceConvertToDto(r)).collect(Collectors.toList());	
		}	
		UserAccountDto userAccountDto = new UserAccountDto(userAccount.getUserName(), userAccount.getPassword(),
				userAccount.getFirstName(), userAccount.getLastName(), services, preferences);	
		return userAccountDto;
	}
	
	/**
	 * Convert Article to dto.
	 * @param article
	 * @author Zichen
	 * @return
	 * @throws Exception
	 */
	public static ArticleDto convertToDto(Article article) {
		if (article == null) {
			throw new IllegalArgumentException("Article does not exist.");
		}
		List<UserAccountDto> userAccounts = new ArrayList<UserAccountDto>();
		List<CategoryDto> types = new ArrayList<CategoryDto>();
		WebsiteDto website = new WebsiteDto();
		SummaryDto summary = new SummaryDto();	
		if (article.getUserAccounts() != null) {
			userAccounts = article.getUserAccounts().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}
		if (article.getType() != null){ // user account has no related history
			types = article.getType().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}		
		if (article.getSource() != null) {
			website = ControllerHelper.convertToDto(article.getSource());
		}
		if (article.getSummary() != null) {
			summary = ControllerHelper.convertToDto(article.getSummary());
		}
		ArticleDto articleDto = new ArticleDto(article.getPublishDate(), article.getPublishTime(),
				article.getNewsID(), article.getUrl(), article.getContent(), article.getTitle(), 
				userAccounts, types, website, summary);
		return articleDto;
	}
	
	/**
	 * Convert Category to dto.
	 * @param category
	 * @author Zichen
	 * @return
	 */
	public static CategoryDto convertToDto(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("Category does not exist.");
		}
		List<UserAccountDto> userAccounts = new ArrayList<UserAccountDto>();
		List<ArticleDto> articles = new ArrayList<ArticleDto>();
		if (category.getUserAccounts() != null) {
			userAccounts = category.getUserAccounts().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}
		if (category.getArticles() != null) {
			articles = category.getArticles().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}
		
		CategoryDto categoryDto = new CategoryDto(category.getType(), userAccounts, articles);
		return categoryDto;
	}
	
	/**
	 * Convert Category to dto.
	 * @param category
	 * @author Zichen
	 * @return
	 */
	public static CategoryDto userPreferenceConvertToDto(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("Error: User Preference does not exist.");
		}
		List<UserAccountDto> userAccounts = new ArrayList<UserAccountDto>();
		List<ArticleDto> articles = new ArrayList<ArticleDto>();

		if (category.getArticles() != null) {
			articles = category.getArticles().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}
		
		CategoryDto categoryDto = new CategoryDto(category.getType(), userAccounts, articles);
		return categoryDto;
	}
	
	/**
	 * Convert Summary to dto.
	 * @param summary
	 * @author Zichen
	 * @return
	 */
	public static SummaryDto convertToDto(Summary summary) {
		if (summary == null) {
			throw new IllegalArgumentException("Summary does not exist.");
		}	
		ArticleDto article = new ArticleDto();	
		if (summary.getArticle() != null) {
			article = ControllerHelper.convertToDto(summary.getArticle());
		}	
		SummaryDto summaryDto = new SummaryDto(summary.getSummaryId(), summary.getNlprResult(), article);
		return summaryDto;
	}
		
	/**
	 * Convert Website to dto.
	 * @param website
	 * @author Zichen
	 * @return
	 */
	public static WebsiteDto convertToDto(Website website) {
		if (website == null) {
			throw new IllegalArgumentException("Source Website does not exist.");
		}	
		List<ArticleDto> articles = new ArrayList<ArticleDto>();	
		if (website.getArticles() != null) {
			articles = website.getArticles().stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}	
		WebsiteDto websiteDto = new WebsiteDto(website.getWebsiteName(), website.getWebsiteURL(), articles);	
		return websiteDto;
	}

}
