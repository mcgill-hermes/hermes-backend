package ecse428.hermes.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import javax.persistence.*;

// line 32 "model.ump"
// line 55 "model.ump"
@Entity
public class Summary
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Summary Attributes

  private int summaryId;

  @Id
  public int getSummaryId() {
    return this.summaryId;
  }

  public void setSummaryId(int id) {
    this.summaryId = id;
  }


  private String nlprResult;

  //Summary Associations
  private Article article;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Summary(String aNlprResult, Article aArticle)
  {
    nlprResult = aNlprResult;
    setArticle(aArticle);

  }

  public Summary() {

  }

  //------------------------
  // INTERFACE
  //------------------------



  public String getNlprResult()
  {
    return nlprResult;
  }

  public void setNlprResult(String aNlprResult)
  {
    boolean wasSet = false;
    nlprResult = aNlprResult;
    wasSet = true;
    //return wasSet;
  }
  /* Code from template association_GetOne */
  @OneToOne(optional = false)
  public Article getArticle()
  {
    return this.article;
  }
  /* Code from template association_SetOneToOptionalOne */

  public void setArticle(Article aNewArticle)
  {
    boolean wasSet = false;
    if (aNewArticle == null)
    {
      //Unable to setArticle to null, as summary must always be associated to a article

      return;
    }
    
    Summary existingSummary = aNewArticle.getSummary();
    if (existingSummary != null && !equals(existingSummary))
    {
      //Unable to setArticle, the current article already has a summary, which would be orphaned if it were re-assigned
      return;
    }
    
    Article anOldArticle = article;
    article = aNewArticle;
    article.setSummary(this);

    if (anOldArticle != null)
    {
      anOldArticle.setSummary(null);
    }
    wasSet = true;
    //return wasSet;
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