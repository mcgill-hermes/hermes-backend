package ecse428.hermes.dto;

import ecse428.hermes.model.Article;

public class SummaryDto {

    private int summaryId;
    private String nlprResult;
    //Summary Associations
    private ArticleDto article;

    public SummaryDto(){
    }

    public SummaryDto(int summaryId,String nlprResult,ArticleDto article ){
        this.summaryId = summaryId;
        this.nlprResult = nlprResult;
        this.article  = article;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public String getNlprResult() {
        return nlprResult;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }
}
