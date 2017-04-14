package pl.allegier.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.service.account.AccountFrontService;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class AccountIT {

    private static final String TEST_LOGIN = "login";
    private static final String TEST_PASSWORD = "pass";

    @Autowired
    private AccountFrontService accountFrontService;

    @Test
    public void createManyProductsTest()
    {
        for( int i=0;i<1000;i++)
        {
            accountFrontService.save( new AccountDto(TEST_LOGIN +i, TEST_PASSWORD+i ));
        }
    }
}

