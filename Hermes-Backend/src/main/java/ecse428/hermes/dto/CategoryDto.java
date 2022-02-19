package ecse428.hermes.dto;

import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.UserAccount;

import java.util.List;

public class CategoryDto {
    private String type;

    //Category Associations
    private List<UserAccountDto> userAccounts;
    private List<ArticleDto> articles;

    public CategoryDto(){

    }

    public CategoryDto(String type,List<UserAccountDto> userAccounts, List<ArticleDto> articles){
        this.type = type;
        this.userAccounts = userAccounts;
        this.articles = articles;
    }

    public String getType(){
        return this.type;
    }

    public List<UserAccountDto> getUserAccounts(){
        return this.userAccounts;
    }

    public void setUserAccounts(List<UserAccountDto> us){
        this.userAccounts = us;
    }

    public List<ArticleDto> getArticles(){
        return this.articles;
    }

    public void setArticles(List<ArticleDto> arts){
        this.articles =arts;
    }

}
