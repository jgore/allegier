package pl.allegier.controller.frontend.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.Service;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */
@org.springframework.stereotype.Service
public class AccountFrontServiceImpl extends AbstractFrontService<AccountDto,Account,Integer> implements AccountFrontService{

    @Autowired
    public AccountFrontServiceImpl(Mapper<AccountDto, Account> accountMapper, Service<Account, Integer> crudService) {
        super(accountMapper, crudService);
    }
}
