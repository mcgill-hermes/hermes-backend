package ecse428.hermes.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 2 "model.ump"
// line 50 "model.ump"
public class UserAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UserAccount Attributes
  private String userName;
  private String password;
  private String firstName;
  private String lastName;

  //UserAccount Associations
  private List<Article> history;
  private List<Category> preference;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserAccount(String aUserName, String aPassword, String aFirstName, String aLastName)
  {
    userName = aUserName;
    password = aPassword;
    firstName = aFirstName;
    lastName = aLastName;
    history = new ArrayList<Article>();
    preference = new ArrayList<Category>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserName(String aUserName)
  {
    boolean wasSet = false;
    userName = aUserName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public String getUserName()
  {
    return userName;
  }

  public String getPassword()
  {
    return password;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }
  /* Code from template association_GetMany */
  public Article getHistory(int index)
  {
    Article aHistory = history.get(index);
    return aHistory;
  }

  public List<Article> getHistory()
  {
    List<Article> newHistory = Collections.unmodifiableList(history);
    return newHistory;
  }

  public int numberOfHistory()
  {
    int number = history.size();
    return number;
  }

  public boolean hasHistory()
  {
    boolean has = history.size() > 0;
    return has;
  }

  public int indexOfHistory(Article aHistory)
  {
    int index = history.indexOf(aHistory);
    return index;
  }
  /* Code from template association_GetMany */
  public Category getPreference(int index)
  {
    Category aPreference = preference.get(index);
    return aPreference;
  }

  public List<Category> getPreference()
  {
    List<Category> newPreference = Collections.unmodifiableList(preference);
    return newPreference;
  }

  public int numberOfPreference()
  {
    int number = preference.size();
    return number;
  }

  public boolean hasPreference()
  {
    boolean has = preference.size() > 0;
    return has;
  }

  public int indexOfPreference(Category aPreference)
  {
    int index = preference.indexOf(aPreference);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHistory()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Article addHistory(Date aPublishDate, Time aPublishTime, int aNewsID, String aUrl, String aContent, String aTitle, Website aSource, Category... allType)
  {
    return new Article(aPublishDate, aPublishTime, aNewsID, aUrl, aContent, aTitle, this, aSource, allType);
  }

  public boolean addHistory(Article aHistory)
  {
    boolean wasAdded = false;
    if (history.contains(aHistory)) { return false; }
    UserAccount existingUserAccount = aHistory.getUserAccount();
    boolean isNewUserAccount = existingUserAccount != null && !this.equals(existingUserAccount);
    if (isNewUserAccount)
    {
      aHistory.setUserAccount(this);
    }
    else
    {
      history.add(aHistory);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHistory(Article aHistory)
  {
    boolean wasRemoved = false;
    //Unable to remove aHistory, as it must always have a userAccount
    if (!this.equals(aHistory.getUserAccount()))
    {
      history.remove(aHistory);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHistoryAt(Article aHistory, int index)
  {  
    boolean wasAdded = false;
    if(addHistory(aHistory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHistory()) { index = numberOfHistory() - 1; }
      history.remove(aHistory);
      history.add(index, aHistory);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHistoryAt(Article aHistory, int index)
  {
    boolean wasAdded = false;
    if(history.contains(aHistory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHistory()) { index = numberOfHistory() - 1; }
      history.remove(aHistory);
      history.add(index, aHistory);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHistoryAt(aHistory, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPreference()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPreference(Category aPreference)
  {
    boolean wasAdded = false;
    if (preference.contains(aPreference)) { return false; }
    preference.add(aPreference);
    if (aPreference.indexOfUserAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPreference.addUserAccount(this);
      if (!wasAdded)
      {
        preference.remove(aPreference);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePreference(Category aPreference)
  {
    boolean wasRemoved = false;
    if (!preference.contains(aPreference))
    {
      return wasRemoved;
    }

    int oldIndex = preference.indexOf(aPreference);
    preference.remove(oldIndex);
    if (aPreference.indexOfUserAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPreference.removeUserAccount(this);
      if (!wasRemoved)
      {
        preference.add(oldIndex,aPreference);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPreferenceAt(Category aPreference, int index)
  {  
    boolean wasAdded = false;
    if(addPreference(aPreference))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreference()) { index = numberOfPreference() - 1; }
      preference.remove(aPreference);
      preference.add(index, aPreference);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePreferenceAt(Category aPreference, int index)
  {
    boolean wasAdded = false;
    if(preference.contains(aPreference))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPreference()) { index = numberOfPreference() - 1; }
      preference.remove(aPreference);
      preference.add(index, aPreference);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPreferenceAt(aPreference, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=history.size(); i > 0; i--)
    {
      Article aHistory = history.get(i - 1);
      aHistory.delete();
    }
    ArrayList<Category> copyOfPreference = new ArrayList<Category>(preference);
    preference.clear();
    for(Category aPreference : copyOfPreference)
    {
      aPreference.removeUserAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userName" + ":" + getUserName()+ "," +
            "password" + ":" + getPassword()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "]";
  }
}