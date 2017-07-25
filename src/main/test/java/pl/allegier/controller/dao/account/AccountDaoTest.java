package pl.allegier.controller.dao.account;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.model.Account;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
public class AccountDaoTest extends AbstractDaoTest<Account, Integer> implements DaoTest<Account, Integer> {

    public static final String TEST_ACCOUNT_LOGIN = " TEST _ PROD _ TITLE 1";
    public static final String TEST_ACCOUNT_LOGIN_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private OrderDaoTest orderDaoTest;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountDao accountDao;

    @After
    public void cleanUp() {
        orderDaoTest.cleanUp();
        accountDao.removeAll();
    }

    @Override
    @Test
    public void saveOneTest() {
        Account Account = createAccount();
        Account saved = accountDao.save(Account);

        Account byId = accountDao.findById(saved.getId());

        assertThat(byId.getId(), equalTo(saved.getId()));
    }

    @Override
    @Test
    public void updateOneTest() {
        Account saved = createAccount();
        saved.setLogin(TEST_ACCOUNT_LOGIN_2);

        Account update = accountDao.update(saved);

        assertThat(update.getLogin(), equalTo(TEST_ACCOUNT_LOGIN_2));

    }

    @Override
    @Test
    public void removeOneTest() {
        Account Account = createAccount();
        Account saved = accountDao.save(Account);

        Account removed = accountDao.remove(saved);

        assertThat(accountDao.findById(removed.getId()), equalTo(null));
    }

    @Override
    @Test
    public void findByIdTest() {
        Account Account = createAccount();
        Account save = accountDao.save(Account);
        Account byId = accountDao.findById(save.getId());

        assertThat(save.getId(), equalTo(byId.getId()));
    }

    @Override
    @Test
    public void findAllTest() {
        Account Account1 = createAccount();
        Account Account2 = createAccount();
        accountDao.save(Account1);
        accountDao.save(Account2);

        List<Account> all = accountDao.findAll();

        assertThat(all.size(), equalTo(2));

    }

    @Override
    @Test
    public void countTest() {
        Account Account1 = createAccount();
        Account Account2 = createAccount();

        accountDao.save(Account1);
        accountDao.save(Account2);

        Long count = accountDao.count();

        assertThat(count, equalTo(2L));

    }

    @Override
    @Test
    public void removeAllTest() {
        Account Account1 = createAccount();
        Account Account2 = createAccount();
        accountDao.save(Account1);
        accountDao.save(Account2);

        accountDao.removeAll();

        assertThat(accountDao.findAll().size(), equalTo(0));
    }

    private Account createAccount() {
        return new Account(TEST_ACCOUNT_LOGIN, TEST_DESCRIPTION);
    }
}
