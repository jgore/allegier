package pl.allegier.controller.service.product;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.model.Product;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class ProductServiceImplTest {

    private static final String TEST_TITLE = "gore";
    private static final String TEST_TITLE_2 = "gore";
    private static final String TEST_DESC = "gore1234";
    private static final BigDecimal TEST_PRICE = BigDecimal.ONE;

    @Autowired
    private ProductService productService;

    @Before
    public void testSetup()
    {
        productService.deleteAll();
    }

    @Test
    public void testGetOne() {
        Product saved = createNew(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));
        Product one = productService.findOne(saved.getId());

        assertThat( one.getTitle() ,equalTo(TEST_TITLE));
        assertThat( one.getDescription() ,equalTo(TEST_DESC));
        assertThat( one.getPrice() ,equalTo(TEST_PRICE));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        Product saved = createNew(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));
        Product next = productService.findAll().iterator().next();

        assertThat(saved,equalTo(next));

    }

    @Test
    public void testSave() {
        Product saved = createNew(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));
        assertThat(saved.getTitle(), equalTo(TEST_TITLE));
    }

    @Test
    public void testUpdate() {
        Product saved = createNew(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));
        assertThat(saved.getTitle(), equalTo(TEST_TITLE));

        saved.setTitle(TEST_TITLE_2);
        Product updated = productService.save( saved );

        assertThat(updated.getTitle(), equalTo(TEST_TITLE_2));
    }

    @Test
    public void testDelete() {
        Product saved = createNew(new Product(TEST_TITLE, TEST_DESC, TEST_PRICE));

        productService.delete( saved.getId() );

        Product one = productService.findOne(saved.getId());
        assertNull( one);
    }

    private Product createNew(Product var1) {
        return productService.save(var1);
    }

}