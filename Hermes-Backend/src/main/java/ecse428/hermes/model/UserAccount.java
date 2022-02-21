package ecse428.hermes.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 2 "model.ump"
// line 50 "model.ump"
@Entity
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

  public UserAccount() {

  }

  //------------------------
  // INTERFACE
  //------------------------

  public void setUserName(String aUserName)
  {
    boolean wasSet = false;
    userName = aUserName;
    wasSet = true;
    //return wasSet;
  }

  public void setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    //return wasSet;
  }

  public void setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    //return wasSet;
  }

  public void setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    //return wasSet;
  }

  @Id
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

  @ManyToMany()
  public List<Article> getHistory()
  {
    return this.history;
  }

  public void setHistory(List<Article> newHistory)
  {
    this.history = newHistory;
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

  @ManyToMany (mappedBy = "userAccounts")
  public List<Category> getPreference()
  {
    return this.preference;
  }

  public void setPreference(List<Category> newPreference)
  {
    this.preference = newPreference;
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
  /* Code from template association_AddManyToManyMethod */
  public boolean addHistory(Article aHistory)
  {
    boolean wasAdded = false;
    if (history.contains(aHistory)) { return false; }
    history.add(aHistory);
    if (aHistory.indexOfUserAccount(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aHistory.addUserAccount(this);
      if (!wasAdded)
      {
        history.remove(aHistory);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeHistory(Article aHistory)
  {
    boolean wasRemoved = false;
    if (!history.contains(aHistory))
    {
      return wasRemoved;
    }

    int oldIndex = history.indexOf(aHistory);
    history.remove(oldIndex);
    if (aHistory.indexOfUserAccount(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aHistory.removeUserAccount(this);
      if (!wasRemoved)
      {
        history.add(oldIndex,aHistory);
      }
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
    ArrayList<Article> copyOfHistory = new ArrayList<Article>(history);
    history.clear();
    for(Article aHistory : copyOfHistory)
    {
      aHistory.removeUserAccount(this);
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