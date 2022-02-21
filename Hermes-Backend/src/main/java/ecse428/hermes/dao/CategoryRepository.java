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

    List<Category> findCategoryByArticlesIn(List<Article> articles);


    List<Category> findCategoryByUserAccountsIn(List<UserAccount> userAccounts);


}
