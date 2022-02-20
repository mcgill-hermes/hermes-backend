package ecse428.hermes.dao;


import ecse428.hermes.model.Article;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.model.Website;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, String>{
    Article findArticleByNewsID(int id);

    Article findArticleByTitle(String title);

    Article findArticleByUrl(String url);

    List<Article> findAllByUserAccounts(UserAccount userAccount);

    List<Article> findArticleBySource(Website website);

    Article findArticleBySummary(Summary summary);

    List<Article> findAllByType(Category type);


}

