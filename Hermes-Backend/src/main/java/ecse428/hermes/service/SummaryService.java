package ecse428.hermes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecse428.hermes.dao.ArticleRepository;
import ecse428.hermes.dao.CategoryRepository;
import ecse428.hermes.dao.SummaryRepository;
import ecse428.hermes.dao.UserAccountRepository;
import ecse428.hermes.dao.WebsiteRepository;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;

@Service
public class SummaryService {
	@Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    WebsiteRepository websiteRepository;
    @Autowired
    SummaryRepository summaryRepository;
    
    /**
     * Create a new summary and save it.
     * @param nlpResult
     * @param article
     * @return
     */
    public Summary createSummary(String nlpResult, Article article) {
    	Summary summary = new Summary();
    	
    	summary.setNlprResult(nlpResult);
    	summary.setArticle(article);
    	
    	summaryRepository.save(summary);
    	
    	return summary;
    }
    
    /**
     * Return a summary by category.
     * @param category
     * @return
     */
    public Summary findSummaryByArticle(Article article) {
    	Summary summary = summaryRepository.findSummaryByArticle(article);
    	
    	if (summary == null) {
    		throw new IllegalArgumentException("Error: there are no such summary");
    	}
    	
    	return summary;
    }
    
}
