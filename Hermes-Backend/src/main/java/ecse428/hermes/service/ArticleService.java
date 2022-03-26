package ecse428.hermes.service;

import ecse428.hermes.dao.*;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
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

    public Article createArticle(Date publishDate, Time publishTime, int newsID, String url, String content,
                                 String title, String websiteName, String mytype) {
        if (publishDate == null || publishTime ==null|| url == null|| content == null|| title == null || websiteName == null
        || mytype == null ) {
            throw new IllegalArgumentException("Error: No input type");
        }
        if(articleRepository.findArticleByNewsID(newsID)!=null){
            throw new IllegalArgumentException("Error: the article with the current newID already exists");
        }
        if (categoryRepository.findCategoryByType(mytype) == null || websiteRepository.findWebsiteByWebsiteName(websiteName)==null) {
            throw new IllegalArgumentException("Error: there are objects that do not exist");
        }
        Category category = categoryRepository.findCategoryByType(mytype);
        List<Category> myCategory = new ArrayList<>();
        myCategory.add(category);
        Website website = websiteRepository.findWebsiteByWebsiteName(websiteName);

        Article article = new Article(publishDate,publishTime,newsID,url,content,title,website,myCategory);
        articleRepository.save(article);
        return article;
    }

    public Website createWebsite( String websiteName, String websiteURL) {
        if ( websiteName == null || websiteURL == null ) {
            throw new IllegalArgumentException("Error: No input type");
        }
        if ( websiteRepository.findWebsiteByWebsiteName(websiteName)!=null) {
            throw new IllegalArgumentException("Error: the objext already exists");
        }
        Website website = new Website(websiteName,websiteURL);
        websiteRepository.save(website);
        return website;
    }

    public List<Website> getAllWebsites(){
        return (List<Website>) websiteRepository.findAll();
    }


    public Article getArticlebyId(int newID){
        return (Article) articleRepository.findArticleByNewsID(newID);
    }

    /**
     * find list of articles by type.
     * @param type -- Category
     * @return
     */
    public List<Article> getArticlesByType(Category type){
    	List<Article> articles = articleRepository.findAllByType(type);
    	
    	return articles;
    }
}
