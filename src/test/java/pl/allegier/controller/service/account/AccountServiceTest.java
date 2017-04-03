package pl.allegier.controller.service.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.model.Account;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Pawel Szczepkowski | Satlan on 03.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Before
    public void testSetup()
    {
        accountService.deleteAll();
    }

    @Test
    public void testGetOne() {
        fail();
    }

    @Test
    public void testGetAll() {
        fail();
    }

    @Test
    public void testSave() {
        Account save = accountService.save(new Account());
        assertThat(save.getId(), equalTo(1));
    }

    @Test
    public void testCreate() {
        fail();
    }

    @Test
    public void testUpdate() {
        fail();
    }

    @Test
    public void testDelete() {
        fail();
    }

}