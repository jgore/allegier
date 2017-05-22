package pl.allegier.controller.dao.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.model.Account;
import pl.allegier.model.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class AccountDaoTest extends AbstractDaoTest<Product,Integer> implements DaoTest<Account,Integer> {

    public static final String TEST_PROD_TITLE_1 = " TEST _ PROD _ TITLE 1";
    public static final String TEST_PROD_TITLE_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);


    @Autowired
    private ProductDao productDao;

    @Before
    public  void setup()
    {
        productDao.removeAll();
    }

    @Override
    @Test
    public void saveOneTest() {
        Product product = createProduct();
        Product saved = productDao.save(product);

        Product byId = productDao.findById(saved.getId());

        assertThat( byId.getId(), equalTo( saved.getId()));
    }

    @Override
    @Test
    public void updateOneTest() {
        Product saved = createProduct();
        saved.setTitle(TEST_PROD_TITLE_2);

        Product update = productDao.update(saved);

        assertThat(update.getTitle(), equalTo(TEST_PROD_TITLE_2));

    }

    @Override
    @Test
    public void removeOneTest() {
        Product product = createProduct();
        Product saved = productDao.save(product);

        Product removed = productDao.remove(saved);

         assertThat( productDao.findById( removed.getId() ),equalTo(  null ));
    }

    @Override
    @Test
    public void findByIdTest() {
        Product product = createProduct();
        Product save = productDao.save(product);
        Product byId = productDao.findById(save.getId());

        assertThat( save.getId(), equalTo( byId.getId()));
    }

    @Override
    @Test
    public void findAllTest() {
        Product product1 = createProduct();
        Product product2 = createProduct();
        productDao.save(product1);
        productDao.save(product2);

        List<Product> all = productDao.findAll();

        assertThat( all.size() , equalTo( 2));

    }

    @Override
    @Test
    public void countTest() {
        Product product1 = createProduct();
        Product product2 = createProduct();

        productDao.save(product1);
        productDao.save(product2);

        Long count = productDao.count();

        assertThat( count , equalTo( 2L));

    }

    @Override
    @Test
    public void removeAllTest() {
        Product product1 = createProduct();
        Product product2 = createProduct();
        productDao.save(product1);
        productDao.save(product2);

        productDao.removeAll();

        assertThat( productDao.findAll().size() ,equalTo( 0));
    }

    private Product createProduct() {
        return new Product(TEST_PROD_TITLE_1,TEST_DESCRIPTION,TEST_PRICE);
    }
}
