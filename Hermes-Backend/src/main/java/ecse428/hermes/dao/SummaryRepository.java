package ecse428.hermes.dao;

import ecse428.hermes.model.Summary;
import org.springframework.data.repository.CrudRepository;
import ecse428.hermes.model.Article;

public interface SummaryRepository extends CrudRepository<Summary, String>{

    Summary findSummaryByArticle(Article article);
}
