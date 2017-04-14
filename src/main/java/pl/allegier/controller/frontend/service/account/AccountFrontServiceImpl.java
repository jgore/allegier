package pl.allegier.controller.frontend.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.CrudService;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | Satlan on 13.04.17.
 */
@Service
public class AccountFrontServiceImpl extends AbstractFrontService<AccountDto,Account,Integer> implements AccountFrontService{

    @Autowired
    public AccountFrontServiceImpl(Mapper<AccountDto, Account> mapper, CrudService<Account, Integer> crudService) {
        super(mapper, crudService);
    }
}
