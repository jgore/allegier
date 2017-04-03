package pl.allegier.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | Satlan on 03.04.17.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
