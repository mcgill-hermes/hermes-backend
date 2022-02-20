package ecse428.hermes.dao;


import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import ecse428.hermes.model.Article;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {
    Category findCategoryByType(String type);

    List<Category> findAllByArticles(Article article);


    List<Category> findAllByUserAccounts(UserAccount userAccount);


}
