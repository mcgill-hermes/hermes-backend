package ecse428.hermes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecse428.hermes.dao.SummaryRepository;
import ecse428.hermes.dto.SummaryDto;
import ecse428.hermes.dto.WebsiteDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.Website;
import ecse428.hermes.service.ArticleService;
import ecse428.hermes.service.CategoryService;
import ecse428.hermes.service.SummaryService;

@CrossOrigin(origins = "*")
@RestController
public class SummaryController {
	@Autowired
	ArticleService articleService;
	@Autowired
	CategoryService categoryService;
    @Autowired
    SummaryService summaryService;
    
    
	/**
     * find summary by category
     *
     * @return a SummaryDto with specified information.
     * @throws Exception
     * @author Zichen Chang
     */
    @GetMapping(value = {"/summary/category", "/summary/category/"})
    public List<SummaryDto> findByCategory(@RequestParam String type) throws Exception {
        try {
        	Category category = categoryService.getCategory(type);
        	List<Article> articles = articleService.getArticlesByType(category);
        	ArrayList<Summary> summaries= new ArrayList<Summary>();
        	for(Article a : articles) {
        		summaries.add(summaryService.findSummaryByArticle(a));
        	}	
           return summaries.stream().map(r -> ControllerHelper.convertToDto(r)).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
	
}
