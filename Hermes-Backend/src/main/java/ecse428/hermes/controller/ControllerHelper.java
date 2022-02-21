package ecse428.hermes.controller;

import ecse428.hermes.dto.UserAccountDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Array;

import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.dto.CategoryDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.UserAccount;

public class ControllerHelper {

	
	/**
	 * Convert an userAccount to Dto.
	 * @param userAccount
	 * @return
	 */
	public static UserAccountDto convertToDto(UserAccount userAccount){
		if (userAccount == null) {
			throw new IllegalArgumentException("UserAccount does not exist.");
		}
		
		List<ArticleDto> services = new ArrayList<ArticleDto>();
		List<CategoryDto> preferences = new ArrayList<CategoryDto>();
		
		if (userAccount.getHistory() != null) {
			services = userAccount.getHistory().stream()
					.map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}else if(userAccount.getPreference() != null){ 
//			preferences = userAccount.getPreference().stream()
//					.map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());	
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
			throw new IllegalArgumentException("UserAccount does not exist.");
		}
		
		List<UserAccountDto> userAccounts = new ArrayList<UserAccountDto>();
		List<CategoryDto> types = new ArrayList<CategoryDto>();
		
		if (article.getUserAccounts() != null) {
			userAccounts = article.getUserAccounts().stream()
					.map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
//			technicianDto.setServices(services);
//			return technicianDto;
			return null;
		}
		if (article.getType() != null){ // user account has no related history
//			types = article.getType().stream()
//					.map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
		}	
		
//		ArticleDto articleDto = new ArticleDto(article.getPublishDate(), article.getPublishTime(),
//				article.getNewsID(), article.getUrl(), article.getContent(), article.getTitle(), userAccounts, types
//				,ControllerHelper.convertToDto(article.getSource()),ControllerHelper.convertToDto(article.getSummary()));
		
		return null;
//		return articleDto;
	}
	
	
	
	
}
