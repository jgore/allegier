package pl.allegier.controller.frontend.service.account;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.AccountDto;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class AccountFrontServiceImplTest {

    private static final String TEST_LOGIN_1 = "gore";
    private static final String TEST_LOGIN_2 = "gore1234";
    private static final String TEST_PASSWORD = "1234";

    @Autowired
    private AccountFrontService accountDtoFrontService;

    @Before
    public void testSetup()
    {
        accountDtoFrontService.deleteAll();
    }

    @Test
    public void testGetOne() {
        AccountDto saved = accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1,TEST_PASSWORD));
        AccountDto one = accountDtoFrontService.findOne(saved.getId());

        assertThat( one.getLogin() ,equalTo(TEST_LOGIN_1));
        assertThat( one.getPassword() ,equalTo( TEST_PASSWORD ));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1, TEST_PASSWORD));
        accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1, TEST_PASSWORD));

        Iterable<AccountDto> all = accountDtoFrontService.findAll();
        List<AccountDto> accountDtos = Lists.newArrayList(all);

        //TODO FIX
        //assertThat(accountDtos.size(), equalTo( 2) );

    }

    @Test
    public void testSave() {
        AccountDto save = accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));
    }

    @Test
    public void testUpdate() {
        AccountDto save = accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

        save.setLogin(TEST_LOGIN_2);
        AccountDto updated = accountDtoFrontService.update(save);

        assertThat(updated.getLogin(), equalTo(TEST_LOGIN_2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDelete() {
        AccountDto save = accountDtoFrontService.save(new AccountDto(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

        accountDtoFrontService.delete( save.getId() );

        AccountDto one = accountDtoFrontService.findOne(save.getId());
        assertNull( one);
    }
}