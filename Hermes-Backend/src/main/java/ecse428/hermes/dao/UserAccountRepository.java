package ecse428.hermes.dao;

import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import org.springframework.data.repository.CrudRepository;
import ecse428.hermes.model.UserAccount;

import java.util.List;

public interface UserAccountRepository extends CrudRepository<UserAccount, String>{
    UserAccount findUserAccountByUserName(String name);

    List<UserAccount> findAllByHistory(Article article);


    List<UserAccount> findAllByPreference(Category category);

    Boolean deleteUserAccountByUserName(String name);

}
