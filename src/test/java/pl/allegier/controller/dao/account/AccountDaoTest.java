package pl.allegier.controller.dao.account;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.order.OrderDaoTest;
import pl.allegier.model.Account;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
public class AccountDaoTest extends AbstractDaoTest<Account, Integer> implements DaoTest<Account, Integer> {

    public static final String TEST_ACCOUNT_LOGIN = "TEST_PROD_TITLE_1";
    public static final String TEST_ACCOUNT_LOGIN_2 = "TEST_PROD_TITLE_2";
    public static final String TEST_DESCRIPTION = " TEST_PROD_DESC";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private OrderDaoTest orderDaoTest;

    @Autowired
    private AccountDao accountDao;

    @Override
    public Dao<Account, Integer> getRepository() {
        return accountDao;
    }

    @After
    public void cleanUp() {
        orderDaoTest.cleanUp();
        accountDao.removeAll();
    }

    @Override
    @Test
    public void saveOneTest() {
        Account Account = createEntity();
        Account saved = accountDao.save(Account);

        Account byId = accountDao.findById(saved.getId());

        assertThat(byId.getId(), equalTo(saved.getId()));
    }

    @Override
    @Test
    public void updateOneTest() {
        Account saved = createEntity();
        saved.setLogin(TEST_ACCOUNT_LOGIN_2);

        Account update = accountDao.update(saved);

        assertThat(update.getLogin(), equalTo(TEST_ACCOUNT_LOGIN_2));

    }

    @Override
    @Test
    public void removeOneTest() {
        Account Account = createEntity();
        Account saved = accountDao.save(Account);

        Account removed = accountDao.remove(saved);

        assertThat(accountDao.findById(removed.getId()), equalTo(null));
    }

    @Override
    @Test
    public void findByIdTest() {
        Account Account = createEntity();
        Account save = accountDao.save(Account);
        Account byId = accountDao.findById(save.getId());

        assertThat(save.getId(), equalTo(byId.getId()));
    }

    @Test
    public void findByLoginTest() {
        Account Account = createEntity();
        Account save = accountDao.save(Account);
        Account byLogin = accountDao.findByLogin(save.getLogin());

        assertThat(save.getLogin(), equalTo(byLogin.getLogin()));
    }

    @Override
    @Test
    public void findAllTest() {
        Account Account1 = createEntity();
        Account Account2 = new Account(TEST_ACCOUNT_LOGIN_2, TEST_DESCRIPTION);
        accountDao.save(Account1);
        accountDao.save(Account2);

        List<Account> all = accountDao.findAll(0,0);

        assertThat(all.size(), equalTo(2));

    }

    @Override
    @Test
    public void countTest() {
        Account Account1 = createEntity();
        Account Account2 = new Account(TEST_ACCOUNT_LOGIN_2, TEST_DESCRIPTION);

        accountDao.save(Account1);
        accountDao.save(Account2);

        Long count = accountDao.count();

        assertThat(count, equalTo(2L));

    }

    @Override
    @Test
    public void removeAllTest() {
        Account Account1 = createEntity();
        Account Account2 = new Account(TEST_ACCOUNT_LOGIN_2, TEST_DESCRIPTION);
        accountDao.save(Account1);
        accountDao.save(Account2);

        accountDao.removeAll();

        assertThat(accountDao.findAll(0,0).size(), equalTo(0));
    }

    public Account createEntity() {
        return new Account(TEST_ACCOUNT_LOGIN, TEST_DESCRIPTION);
    }
}
