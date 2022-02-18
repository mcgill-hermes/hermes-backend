package ecse428.hermes.dto;

import ecse428.hermes.model.Article;
import ecse428.hermes.model.Website;

import java.util.List;

public class WebsiteDto {
    private String websiteName;
    private String websiteURL;
    private List<Article> articles;

    public WebsiteDto(){
    }

    public WebsiteDto(String websiteName, String websiteURL, List<Article> articles){
        this.websiteName = websiteName;
        this.websiteURL = websiteURL;
        this.articles = articles;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
