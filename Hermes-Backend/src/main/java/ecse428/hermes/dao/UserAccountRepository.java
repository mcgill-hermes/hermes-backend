package ecse428.hermes.dao;

import org.springframework.data.repository.CrudRepository;
import ecse428.hermes.model.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, String>{
    UserAccount findUserAccountByUserName(String name);


}
