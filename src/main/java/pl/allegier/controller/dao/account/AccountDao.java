package pl.allegier.controller.dao.account;

import pl.allegier.controller.dao.Dao;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */
public interface AccountDao extends Dao<Account, Integer> {

    /**
     * find in DB by login
     * @param login
     * @return
     */
    Account findByLogin(final String login);
}
