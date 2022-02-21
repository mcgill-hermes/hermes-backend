package ecse428.hermes.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 20 "model.ump"
// line 70 "model.ump"
@Entity
public class Website
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Website Attributes
  private String websiteName;
  private String websiteURL;

  //Website Associations
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Website(String aWebsiteName, String aWebsiteURL)
  {
    websiteName = aWebsiteName;
    websiteURL = aWebsiteURL;
    articles = new ArrayList<Article>();
  }

  public Website() {

  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setWebsiteName(String aWebsiteName)
  {
    boolean wasSet = false;
    websiteName = aWebsiteName;
    wasSet = true;
    //return wasSet;
  }

  public void setWebsiteURL(String aWebsiteURL)
  {
    boolean wasSet = false;
    websiteURL = aWebsiteURL;
    wasSet = true;
    //return wasSet;
  }

  public String getWebsiteName()
  {
    return websiteName;
  }




  @Id
  public String getWebsiteURL()
  {
    return websiteURL;
  }
  /* Code from template association_GetMany */
  public Article getArticle(int index)
  {
    Article aArticle = articles.get(index);
    return aArticle;
  }

  @OneToMany(mappedBy = "source")
  public List<Article> getArticles()
  {
    return this.articles;
  }

  public void setArticles(List<Article> newArticles)
  {
    this.articles = newArticles;
  }

  public int numberOfArticles()
  {
    int number = articles.size();
    return number;
  }

  public boolean hasArticles()
  {
    boolean has = articles.size() > 0;
    return has;
  }

  public int indexOfArticle(Article aArticle)
  {
    int index = articles.indexOf(aArticle);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArticles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Article addArticle(Date aPublishDate, Time aPublishTime, int aNewsID, String aUrl, String aContent, String aTitle, UserAccount aUserAccount, List<Category> allType)
  {
    return new Article(aPublishDate, aPublishTime, aNewsID, aUrl, aContent, aTitle, aUserAccount, this, allType);
  }

  public boolean addArticle(Article aArticle)
  {
    boolean wasAdded = false;
    if (articles.contains(aArticle)) { return false; }
    Website existingSource = aArticle.getSource();
    boolean isNewSource = existingSource != null && !this.equals(existingSource);
    if (isNewSource)
    {
      aArticle.setSource(this);
    }
    else
    {
      articles.add(aArticle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArticle(Article aArticle)
  {
    boolean wasRemoved = false;
    //Unable to remove aArticle, as it must always have a source
    if (!this.equals(aArticle.getSource()))
    {
      articles.remove(aArticle);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArticleAt(Article aArticle, int index)
  {  
    boolean wasAdded = false;
    if(addArticle(aArticle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArticles()) { index = numberOfArticles() - 1; }
      articles.remove(aArticle);
      articles.add(index, aArticle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArticleAt(Article aArticle, int index)
  {
    boolean wasAdded = false;
    if(articles.contains(aArticle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArticles()) { index = numberOfArticles() - 1; }
      articles.remove(aArticle);
      articles.add(index, aArticle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArticleAt(aArticle, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=articles.size(); i > 0; i--)
    {
      Article aArticle = articles.get(i - 1);
      aArticle.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "websiteName" + ":" + getWebsiteName()+ "," +
            "websiteURL" + ":" + getWebsiteURL()+ "]";
  }
}