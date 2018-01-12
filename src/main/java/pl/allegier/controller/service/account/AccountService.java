package pl.allegier.controller.service.account;

import pl.allegier.controller.service.Service;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */

public interface AccountService extends Service<Account, Integer> {
    /**
     * find in db by login
     * @param login
     * @return
     */
    Account findByLogin(String login);

}
