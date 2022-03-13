package ecse428.hermes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecse428.hermes.dao.ArticleRepository;
import ecse428.hermes.dao.CategoryRepository;
import ecse428.hermes.dao.UserAccountRepository;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.UserAccount;

@Service
public class CategoryService {
	@Autowired
	UserAccountRepository userAccountRepository;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	
	/**
	 * Create a new category in db.
	 * @param type
	 * @return a category
	 * @author Zichen
	 */
	public Category createCategory(String type) {
		if (type == null) {
			throw new IllegalArgumentException("Error: No input type");
		}
		if (categoryRepository.findCategoryByType(type) != null) {
			throw new IllegalArgumentException("Error: Current category already existed");
		}
		Category category = new Category(type);
		categoryRepository.save(category);
		return category;
	}
	
	/**
	 * Show all categories in db.
	 * @return a list of all categories
	 * @author Zichen
	 */
	public List<Category> getCategories(){
		return (List<Category>) categoryRepository.findAll();
	}

	/**
	 * Show all categories in db.
	 * @return a list of all categories
	 * @author Zichen
	 */
	public List<String> getCategoriesTypes(){
		return (List<String>) categoryRepository.findAllTypes();
	}

	/**
	 * Find a category in db.
	 * @param type
	 * @return a category
	 * @author kuachen
	 */
	public Category getCategory(String type){
		if (type == null) {
			throw new IllegalArgumentException("Error: No input type");
		}
		if (categoryRepository.findCategoryByType(type) == null) {
			throw new IllegalArgumentException("Error: No category exists");
		} else {
			Category category = categoryRepository.findCategoryByType(type);
			return category;
		}
	}
}
