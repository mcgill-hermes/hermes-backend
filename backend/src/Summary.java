/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 32 "model.ump"
// line 55 "model.ump"
public class Summary
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Summary Attributes
  private String nlprResult;

  //Summary Associations
  private Article article;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Summary(String aNlprResult, Article aArticle)
  {
    nlprResult = aNlprResult;
    boolean didAddArticle = setArticle(aArticle);
    if (!didAddArticle)
    {
      throw new RuntimeException("Unable to create summary due to article. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNlprResult(String aNlprResult)
  {
    boolean wasSet = false;
    nlprResult = aNlprResult;
    wasSet = true;
    return wasSet;
  }

  public String getNlprResult()
  {
    return nlprResult;
  }
  /* Code from template association_GetOne */
  public Article getArticle()
  {
    return article;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setArticle(Article aNewArticle)
  {
    boolean wasSet = false;
    if (aNewArticle == null)
    {
      //Unable to setArticle to null, as summary must always be associated to a article
      return wasSet;
    }
    
    Summary existingSummary = aNewArticle.getSummary();
    if (existingSummary != null && !equals(existingSummary))
    {
      //Unable to setArticle, the current article already has a summary, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Article anOldArticle = article;
    article = aNewArticle;
    article.setSummary(this);

    if (anOldArticle != null)
    {
      anOldArticle.setSummary(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Article existingArticle = article;
    article = null;
    if (existingArticle != null)
    {
      existingArticle.setSummary(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nlprResult" + ":" + getNlprResult()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "article = "+(getArticle()!=null?Integer.toHexString(System.identityHashCode(getArticle())):"null");
  }
}