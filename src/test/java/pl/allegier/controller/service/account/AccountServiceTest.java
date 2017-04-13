package pl.allegier.controller.service.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.model.Account;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | Satlan on 03.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class AccountServiceTest {

    private static final String TEST_LOGIN_1 = "gore";
    private static final String TEST_LOGIN_2 = "gore1234";
    private static final String TEST_PASSWORD = "1234";

    @Autowired
    private AccountService accountService;

    @Before
    public void testSetup()
    {
        accountService.deleteAll();
    }

    @Test
    public void testGetOne() {
        Account saved = accountService.save(new Account(TEST_LOGIN_1,TEST_PASSWORD));
        Account one = accountService.findOne(saved.getId());

        assertThat( one.getLogin() ,equalTo(TEST_LOGIN_1));
        assertThat( one.getPassword() ,equalTo( TEST_PASSWORD ));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        Account save = accountService.save(new Account(TEST_LOGIN_1, TEST_PASSWORD));
        Account next = accountService.findAll().iterator().next();

        assertThat(save,equalTo(next));

    }

    @Test
    public void testSave() {
        Account save = accountService.save(new Account(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getId(), equalTo(1));
    }

    @Test
    public void testUpdate() {
        Account save = accountService.save(new Account(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

        save.setLogin(TEST_LOGIN_2);
        Account updated = accountService.save(save);

        assertThat(updated.getLogin(), equalTo(TEST_LOGIN_2));
    }

    @Test
    public void testDelete() {
        Account save = accountService.save(new Account(TEST_LOGIN_1,TEST_PASSWORD));
        assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

        accountService.delete( save.getId() );

        Account one = accountService.findOne(save.getId());
        assertNull( one);
    }

}