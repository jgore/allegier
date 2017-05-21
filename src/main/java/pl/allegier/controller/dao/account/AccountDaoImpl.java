package pl.allegier.controller.dao.account;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("accountDao")
public class AccountDaoImpl  extends JpaDao<Account,Integer> implements AccountDao{

}
