package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.account.AccountFrontService;
import pl.allegier.model.Account;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */
@RestController
@RequestMapping("rest/accounts")
public class AccountRestController extends AbstractRestController<AccountDto, Integer> {

    private final AccountFrontService accountFrontService;

    @Autowired
    public AccountRestController(final AccountFrontService frontService) {
        this.accountFrontService = frontService;
    }

    @Override
    public final FrontService<AccountDto, Integer> getFrontService() {
        return accountFrontService;
    }
}
