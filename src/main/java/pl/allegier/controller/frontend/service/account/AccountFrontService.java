package pl.allegier.controller.frontend.service.account;

import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */
public interface AccountFrontService extends FrontService<AccountDto, Integer> {

    /**
     * find by login in db
     * @param login
     * @return
     */
    Account findByLogin(String login);
}
