/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 27 "model.ump"
// line 60 "model.ump"
public class Category
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Category Attributes
  private String type;

  //Category Associations
  private List<UserAccount> userAccounts;
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Category(String aType)
  {
    type = aType;
    userAccounts = new ArrayList<UserAccount>();
    articles = new ArrayList<Article>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }
  /* Code from template association_GetMany */
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
  public Article getArticle(int index)
  {
    Article aArticle = articles.get(index);
    return aArticle;
  }

  public List<Article> getArticles()
  {
    List<Article> newArticles = Collections.unmodifiableList(articles);
    return newArticles;
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
    if (aUserAccount.indexOfPreference(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUserAccount.addPreference(this);
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
    if (aUserAccount.indexOfPreference(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUserAccount.removePreference(this);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArticles()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addArticle(Article aArticle)
  {
    boolean wasAdded = false;
    if (articles.contains(aArticle)) { return false; }
    articles.add(aArticle);
    if (aArticle.indexOfType(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aArticle.addType(this);
      if (!wasAdded)
      {
        articles.remove(aArticle);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeArticle(Article aArticle)
  {
    boolean wasRemoved = false;
    if (!articles.contains(aArticle))
    {
      return wasRemoved;
    }

    int oldIndex = articles.indexOf(aArticle);
    articles.remove(oldIndex);
    if (aArticle.indexOfType(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aArticle.removeType(this);
      if (!wasRemoved)
      {
        articles.add(oldIndex,aArticle);
      }
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
    ArrayList<UserAccount> copyOfUserAccounts = new ArrayList<UserAccount>(userAccounts);
    userAccounts.clear();
    for(UserAccount aUserAccount : copyOfUserAccounts)
    {
      aUserAccount.removePreference(this);
    }
    ArrayList<Article> copyOfArticles = new ArrayList<Article>(articles);
    articles.clear();
    for(Article aArticle : copyOfArticles)
    {
      if (aArticle.numberOfType() <= Article.minimumNumberOfType())
      {
        aArticle.delete();
      }
      else
      {
        aArticle.removeType(this);
      }
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "type" + ":" + getType()+ "]";
  }
}