package ecse428.hermes.controller;

import java.util.List;
import java.util.stream.Collectors;

import ecse428.hermes.dto.UserAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecse428.hermes.dto.CategoryDto;
import ecse428.hermes.model.Category;
import ecse428.hermes.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * Create a new category
	 *
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return a UserAccountDto with specified information.
	 * @throws Exception
	 * @author Zichen
	 */
	@PostMapping(value = {"/category/create", "/category/create/"})
	public CategoryDto createCategory(@RequestParam String category) throws Exception {
		try {
			Category newCategory = categoryService.createCategory(category);
			return ControllerHelper.convertToDto(newCategory);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * Return all categories in the db.
	 * @return
	 * @throws Exception
	 * @author Zichen
	 */
	@GetMapping(value = {"/category/get", "/category/get/"})
	public List<CategoryDto> getCategories() throws Exception {
		try {
			List<Category> newCategory = categoryService.getCategories();
			return newCategory.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@GetMapping(value = {"/category/types", "/category"})
	public List<String> getCategoryTypes() throws Exception {
		return categoryService.getCategoriesTypes();
	}

	@GetMapping(value = {"/getCategory", "/getCategory/"})
	public CategoryDto getCategory(@RequestParam String type){
		Category category = categoryService.getCategory(type);
		CategoryDto dto = ControllerHelper.convertToDto(category);
		return dto;
	}

}
