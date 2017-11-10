package pl.allegier.controller.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */

@Service
public class AccountServiceImpl extends AbstractService<Account,Integer> implements AccountService{

    @Autowired
    public AccountServiceImpl(@Qualifier("accountDao") Dao<Account, Integer> jpaDao) {
        super(jpaDao);
    }

}
