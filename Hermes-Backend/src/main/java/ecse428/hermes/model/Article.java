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
  private List<UserAccount> userAccounts;
  private List<Category> type;
  private Website source;
  private Summary summary;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Article(Date aPublishDate, Time aPublishTime, int aNewsID, String aUrl, String aContent, String aTitle, Website aSource, Category... allType)
  {
    publishDate = aPublishDate;
    publishTime = aPublishTime;
    newsID = aNewsID;
    url = aUrl;
    content = aContent;
    title = aTitle;
    userAccounts = new ArrayList<UserAccount>();
    type = new ArrayList<Category>();
    boolean didAddType = setType(allType);
    if (!didAddType)
    {
      throw new RuntimeException("Unable to create Article, must have at least 1 type. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddSource = setSource(aSource);
    if (!didAddSource)
    {
      throw new RuntimeException("Unable to create article due to source. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  /* Code from template association_GetMany */
  @ManyToMany()
  public UserAccount getUserAccount(int index)
  {
    UserAccount aUserAccount = userAccounts.get(index);
    return aUserAccount;
  }

  public List<UserAccount> getUserAccounts()
  {
    List<UserAccount> newUserAccounts = Collections.unmodifiableList(userAccounts);
    return newUserAccounts;
  }

  public int numberOfUserAccounts()
  {
    int number = userAccounts.size();
    return number;
  }

  public boolean hasUserAccounts()
  {
    boolean has = userAccounts.size() > 0;
    return has;
  }

  public int indexOfUserAccount(UserAccount aUserAccount)
  {
    int index = userAccounts.indexOf(aUserAccount);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUserAccount(UserAccount aUserAccount)
  {
    boolean wasAdded = false;
    if (userAccounts.contains(aUserAccount)) { return false; }
    userAccounts.add(aUserAccount);
    if (aUserAccount.indexOfHistory(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUserAccount.addHistory(this);
      if (!wasAdded)
      {
        userAccounts.remove(aUserAccount);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeUserAccount(UserAccount aUserAccount)
  {
    boolean wasRemoved = false;
    if (!userAccounts.contains(aUserAccount))
    {
      return wasRemoved;
    }

    int oldIndex = userAccounts.indexOf(aUserAccount);
    userAccounts.remove(oldIndex);
    if (aUserAccount.indexOfHistory(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUserAccount.removeHistory(this);
      if (!wasRemoved)
      {
        userAccounts.add(oldIndex,aUserAccount);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAccountAt(UserAccount aUserAccount, int index)
  {
    boolean wasAdded = false;
    if(addUserAccount(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAccountAt(UserAccount aUserAccount, int index)
  {
    boolean wasAdded = false;
    if(userAccounts.contains(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    }
    else
    {
      wasAdded = addUserAccountAt(aUserAccount, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTypeValid()
  {
    boolean isValid = numberOfType() >= minimumNumberOfType();
    return isValid;
  }
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

    if (verifiedType.size() != newType.length || verifiedType.size() < minimumNumberOfType())
    {
      return wasSet;
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
    return wasSet;
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
  public boolean setSource(Website aSource)
  {
    boolean wasSet = false;
    if (aSource == null)
    {
      return wasSet;
    }

    Website existingSource = source;
    source = aSource;
    if (existingSource != null && !existingSource.equals(aSource))
    {
      existingSource.removeArticle(this);
    }
    source.addArticle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setSummary(Summary aNewSummary)
  {
    boolean wasSet = false;
    if (summary != null && !summary.equals(aNewSummary) && equals(summary.getArticle()))
    {
      //Unable to setSummary, as existing summary would become an orphan
      return wasSet;
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
    return wasSet;
  }

  public void delete()
  {
    ArrayList<UserAccount> copyOfUserAccounts = new ArrayList<UserAccount>(userAccounts);
    userAccounts.clear();
    for(UserAccount aUserAccount : copyOfUserAccounts)
    {
      aUserAccount.removeHistory(this);
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
            "  " + "source = "+(getSource()!=null?Integer.toHexString(System.identityHashCode(getSource())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "summary = "+(getSummary()!=null?Integer.toHexString(System.identityHashCode(getSummary())):"null");
  }
}