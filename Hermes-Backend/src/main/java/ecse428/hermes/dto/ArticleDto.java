package ecse428.hermes.dto;

import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.model.Website;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class ArticleDto {
    private Date publishDate;
    private Time publishTime;
    private int newsID;
    private String url;
    private String content;
    private String title;

    //Article Associations
    private UserAccount userAccount;
    private List<Category> type;
    private Website source;
    private Summary summary;

    public ArticleDto(){
    }

    public ArticleDto(Date publishDate, Time publishTime, int newsID, String url, String content, String title
                      ,UserAccount userAccount, List<Category> type,Website source, Summary summary ){
        this.publishDate = publishDate;
        this.publishTime = publishTime;
        this.newsID = newsID;
        this.url = url;
        this.content = content;
        this.title = title;
        this.userAccount = userAccount;
        this.type = type;
        this.source = source;
        this.summary = summary;
    }

    public Date getPublishDate(){
        return this.publishDate;
    }

    public Time getPublishTime(){
        return this.publishTime;
    }

    public int getNewsID(){
        return this.newsID;
    }

    public String getUrl(){
        return  this.url;
    }

    public String getContent(){
        return this.content;
    }

    public String getTitle(){
        return this.title;
    }

    public UserAccount getUserAccount(){
        return this.userAccount;
    }

    public void setUserAccount(UserAccount u){
        this.userAccount = u;
    }

    public List<Category> getType(){
        return this.type;
    }

    public void setType (List<Category> t){
        this.type = t;
    }

    public Website getSource(){
        return this.source;
    }

    public void setSource(Website w){
        this.source = w;
    }

    public Summary getSummary(){
        return this.summary;
    }

    public void setSummary(Summary s){
        this.summary = s;
    }
}
