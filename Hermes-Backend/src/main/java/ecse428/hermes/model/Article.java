package ecse428.hermes.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

// line 10 "model.ump"
// line 65 "model.ump"
@Entity
public class Article
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Article Attributes
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Article(Date aPublishDate, Time aPublishTime, int aNewsID, String aUrl, String aContent, String aTitle, UserAccount aUserAccount, Website aSource, List<Category> allType)
  {
    publishDate = aPublishDate;
    publishTime = aPublishTime;
    newsID = aNewsID;
    url = aUrl;
    content = aContent;
    title = aTitle;
    setUserAccount(aUserAccount);

    type = new ArrayList<Category>();
    setType(allType);

    setSource(aSource);

  }

  public Article() {

  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setPublishDate(Date aPublishDate)
  {
    boolean wasSet = false;
    publishDate = aPublishDate;
    wasSet = true;
    //return wasSet;
  }

  public void setPublishTime(Time aPublishTime)
  {
    boolean wasSet = false;
    publishTime = aPublishTime;
    wasSet = true;
    //return wasSet;
  }

  public void setNewsID(int aNewsID)
  {
    boolean wasSet = false;
    newsID = aNewsID;
    wasSet = true;
    //return wasSet;
  }

  public void setUrl(String aUrl)
  {
    boolean wasSet = false;
    url = aUrl;
    wasSet = true;
    //return wasSet;
  }

  public void setContent(String aContent)
  {
    boolean wasSet = false;
    content = aContent;
    wasSet = true;
    //return wasSet;
  }

  public void setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    //return wasSet;
  }

  public Date getPublishDate()
  {
    return publishDate;
  }

  public Time getPublishTime()
  {
    return publishTime;
  }

  @Id
  public int getNewsID()
  {
    return newsID;
  }

  public String getUrl()
  {
    return url;
  }

  public String getContent()
  {
    return content;
  }

  public String getTitle()
  {
    return title;
  }
  /* Code from template association_GetOne */
  @ManyToOne
  public UserAccount getUserAccount()
  {
    return userAccount;
  }


  /* Code from template association_GetMany */
  public Category getType(int index)
  {
    Category aType = type.get(index);
    return aType;
  }

  @ManyToMany(mappedBy = "articles")
  public List<Category> getType()
  {
    List<Category> newType = Collections.unmodifiableList(type);
    return newType;
  }

  public int numberOfType()
  {
    int number = type.size();
    return number;
  }

  public boolean hasType()
  {
    boolean has = type.size() > 0;
    return has;
  }

  public int indexOfType(Category aType)
  {
    int index = type.indexOf(aType);
    return index;
  }
  /* Code from template association_GetOne */
  @ManyToOne
  public Website getSource()
  {
    return source;
  }
  /* Code from template association_GetOne */

  @OneToOne
  public Summary getSummary()
  {
    return summary;
  }

  public boolean hasSummary()
  {
    boolean has = summary != null;
    return has;
  }
  /* Code from template association_SetOneToMany */
  public void setUserAccount(UserAccount aUserAccount)
  {
    boolean wasSet = false;
    if (aUserAccount == null)
    {
      return;
    }

    UserAccount existingUserAccount = userAccount;
    userAccount = aUserAccount;
    if (existingUserAccount != null && !existingUserAccount.equals(aUserAccount))
    {
      existingUserAccount.removeHistory(this);
    }
    userAccount.addHistory(this);
    wasSet = true;
    return;
  }
  /* Code from template association_IsNumberOfValidMethod
  public boolean isNumberOfTypeValid()
  {
    boolean isValid = numberOfType() >= minimumNumberOfType();
    return isValid;
  }*/
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfType()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addType(Category aType)
  {
    boolean wasAdded = false;
    if (type.contains(aType)) { return false; }
    type.add(aType);
    if (aType.indexOfArticle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aType.addArticle(this);
      if (!wasAdded)
      {
        type.remove(aType);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeType(Category aType)
  {
    boolean wasRemoved = false;
    if (!type.contains(aType))
    {
      return wasRemoved;
    }

    if (numberOfType() <= minimumNumberOfType())
    {
      return wasRemoved;
    }

    int oldIndex = type.indexOf(aType);
    type.remove(oldIndex);
    if (aType.indexOfArticle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aType.removeArticle(this);
      if (!wasRemoved)
      {
        type.add(oldIndex,aType);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public void setType(List<Category> newType)
  {
    boolean wasSet = false;
    ArrayList<Category> verifiedType = new ArrayList<Category>();
    for (Category aType : newType)
    {
      if (verifiedType.contains(aType))
      {
        continue;
      }
      verifiedType.add(aType);
    }



    ArrayList<Category> oldType = new ArrayList<Category>(type);
    type.clear();
    for (Category aNewType : verifiedType)
    {
      type.add(aNewType);
      if (oldType.contains(aNewType))
      {
        oldType.remove(aNewType);
      }
      else
      {
        aNewType.addArticle(this);
      }
    }

    for (Category anOldType : oldType)
    {
      anOldType.removeArticle(this);
    }
    wasSet = true;
    return ;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTypeAt(Category aType, int index)
  {  
    boolean wasAdded = false;
    if(addType(aType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfType()) { index = numberOfType() - 1; }
      type.remove(aType);
      type.add(index, aType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTypeAt(Category aType, int index)
  {
    boolean wasAdded = false;
    if(type.contains(aType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfType()) { index = numberOfType() - 1; }
      type.remove(aType);
      type.add(index, aType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTypeAt(aType, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public void setSource(Website aSource)
  {
    boolean wasSet = false;
    if (aSource == null)
    {
      return ;
    }

    Website existingSource = source;
    source = aSource;
    if (existingSource != null && !existingSource.equals(aSource))
    {
      existingSource.removeArticle(this);
    }
    source.addArticle(this);
    wasSet = true;
    return ;
  }
  /* Code from template association_SetOptionalOneToOne */
  public void setSummary(Summary aNewSummary)
  {
    boolean wasSet = false;
    if (summary != null && !summary.equals(aNewSummary) && equals(summary.getArticle()))
    {
      //Unable to setSummary, as existing summary would become an orphan
      return ;
    }

    summary = aNewSummary;
    Article anOldArticle = aNewSummary != null ? aNewSummary.getArticle() : null;

    if (!this.equals(anOldArticle))
    {
      if (anOldArticle != null)
      {
        anOldArticle.summary = null;
      }
      if (summary != null)
      {
        summary.setArticle(this);
      }
    }
    wasSet = true;
    return ;
  }

  public void delete()
  {
    UserAccount placeholderUserAccount = userAccount;
    this.userAccount = null;
    if(placeholderUserAccount != null)
    {
      placeholderUserAccount.removeHistory(this);
    }
    ArrayList<Category> copyOfType = new ArrayList<Category>(type);
    type.clear();
    for(Category aType : copyOfType)
    {
      aType.removeArticle(this);
    }
    Website placeholderSource = source;
    this.source = null;
    if(placeholderSource != null)
    {
      placeholderSource.removeArticle(this);
    }
    Summary existingSummary = summary;
    summary = null;
    if (existingSummary != null)
    {
      existingSummary.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "newsID" + ":" + getNewsID()+ "," +
            "url" + ":" + getUrl()+ "," +
            "content" + ":" + getContent()+ "," +
            "title" + ":" + getTitle()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "publishDate" + "=" + (getPublishDate() != null ? !getPublishDate().equals(this)  ? getPublishDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "publishTime" + "=" + (getPublishTime() != null ? !getPublishTime().equals(this)  ? getPublishTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "userAccount = "+(getUserAccount()!=null?Integer.toHexString(System.identityHashCode(getUserAccount())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "source = "+(getSource()!=null?Integer.toHexString(System.identityHashCode(getSource())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "summary = "+(getSummary()!=null?Integer.toHexString(System.identityHashCode(getSummary())):"null");
  }
}