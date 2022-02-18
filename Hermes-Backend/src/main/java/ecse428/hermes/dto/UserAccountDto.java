package ecse428.hermes.dto;

import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;

import java.util.List;

public class UserAccountDto {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

    //UserAccount Associations
    private List<ArticleDto> history;
    private List<CategoryDto> preference;

    public UserAccountDto(){
    }

    public UserAccountDto(String userName,String password,String firstName, String lastName, List<ArticleDto> articles, List<CategoryDto> preference){
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.history = articles;
        this.preference = preference;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<ArticleDto> getHistory() {
        return history;
    }

    public void setHistory(List<ArticleDto> history) {
        this.history = history;
    }

    public List<CategoryDto> getPreference() {
        return preference;
    }

    public void setPreference(List<CategoryDto> preference) {
        this.preference = preference;
    }
}
