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
    private List<Article> history;
    private List<Category> preference;

    public UserAccountDto(){
    }

    public UserAccountDto(String userName,String password,String firstName, String lastName, List<Article> articles, List<Category> preference){
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

    public List<Article> getHistory() {
        return history;
    }

    public void setHistory(List<Article> history) {
        this.history = history;
    }

    public List<Category> getPreference() {
        return preference;
    }

    public void setPreference(List<Category> preference) {
        this.preference = preference;
    }
}
