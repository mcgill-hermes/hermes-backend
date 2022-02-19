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
    private List<UserAccountDto> userAccountdtos;
    private List<CategoryDto> typedto;
    private WebsiteDto sourcedto;
    private SummaryDto summaryDto;

    public ArticleDto(){
    }

    public ArticleDto(Date publishDate, Time publishTime, int newsID, String url, String content, String title
                      ,List<UserAccountDto> userAccounts, List<CategoryDto> type,WebsiteDto source, SummaryDto summary ){
        this.publishDate = publishDate;
        this.publishTime = publishTime;
        this.newsID = newsID;
        this.url = url;
        this.content = content;
        this.title = title;
        this.userAccountdtos = userAccounts;
        this.typedto = type;
        this.sourcedto = source;
        this.summaryDto = summary;
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

    public List<UserAccountDto> getUserAccountdtos() {
        return userAccountdtos;
    }

    public void setUserAccountdtos(List<UserAccountDto> userAccountdtos) {
        this.userAccountdtos = userAccountdtos;
    }

    public List<CategoryDto> getTypedto() {
        return typedto;
    }

    public void setTypedto(List<CategoryDto> typedto) {
        this.typedto = typedto;
    }

    public SummaryDto getSummaryDto() {
        return summaryDto;
    }

    public void setSummaryDto(SummaryDto summaryDto) {
        this.summaryDto = summaryDto;
    }

    public WebsiteDto getSourcedto() {
        return sourcedto;
    }

    public void setSourcedto(WebsiteDto sourcedto) {
        this.sourcedto = sourcedto;
    }
}
