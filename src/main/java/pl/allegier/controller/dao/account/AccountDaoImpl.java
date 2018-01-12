package pl.allegier.controller.dao.account;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Account;

import javax.persistence.TypedQuery;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("accountDao")
public class AccountDaoImpl extends JpaDao<Account, Integer> implements AccountDao {

    @Override
    public final Account findByLogin(final String login) {
        TypedQuery<Account> tq = em.createQuery("from Account WHERE login=?1", Account.class);
        tq.setParameter(1, login);
        return tq.getSingleResult();
    }

}
