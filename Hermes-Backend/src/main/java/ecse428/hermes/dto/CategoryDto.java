package ecse428.hermes.dto;

import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.UserAccount;

import java.util.List;

public class CategoryDto {
    private String type;

    //Category Associations
    private List<UserAccount> userAccounts;
    private List<Article> articles;

    public CategoryDto(){

    }

    public CategoryDto(String type,List<UserAccount> userAccounts, List<Article> articles){
        this.type = type;
        this.userAccounts = userAccounts;
        this.articles = articles;
    }

    public String getType(){
        return this.type;
    }

    public List<UserAccount> getUserAccounts(){
        return this.userAccounts;
    }

    public void setUserAccounts(List<UserAccount> us){
        this.userAccounts = us;
    }

    public List<Article> getArticles(){
        return this.articles;
    }

    public void setArticles(List<Article> arts){
        this.articles =arts;
    }

}
