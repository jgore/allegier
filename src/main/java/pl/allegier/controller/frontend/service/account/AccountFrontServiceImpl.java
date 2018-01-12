package pl.allegier.controller.frontend.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.Service;
import pl.allegier.controller.service.account.AccountService;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */
@org.springframework.stereotype.Service
public class AccountFrontServiceImpl extends AbstractFrontService<AccountDto, Account, Integer> implements AccountFrontService {

    private final AccountService accountService;

    @Autowired
    public AccountFrontServiceImpl(final Mapper<AccountDto, Account> accountMapper, final Service<Account, Integer> crudService) {
        super(accountMapper, crudService);
        this.accountService = (AccountService) crudService;
    }

    @Override
    public Account findByLogin(final String login) {
        return accountService.findByLogin(login);
    }
}
