package pl.allegier.controller.service.product;

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
import pl.allegier.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;

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
        Product saved = productService.save(createTestEntity());
        Product one = productService.findOne(saved.getId());

        assertThat( one.getTitle() ,equalTo(TEST_TITLE));
        assertThat( one.getDescription() ,equalTo(TEST_DESC));
        assertThat( one.getPrice() ,equalTo(TEST_PRICE));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        Product saved1 = productService.save( createTestEntity() );
        Product saved2 = productService.save( createTestEntity() );

        Product next1 = productService.findOne(saved1.getId());
        Product next2 = productService.findOne(saved2.getId());

        productService.findAll(Arrays.asList(next1.getId(), next2.getId()));

    }

    @Test
    public void testSave() {
        Product saved = productService.save( createTestEntity() );
        assertThat(saved.getTitle(), equalTo(TEST_TITLE));
    }

    @Test
    public void testUpdate() {
        Product saved = productService.save( createTestEntity() );
        assertThat(saved.getTitle(), equalTo(TEST_TITLE));

        saved.setTitle(TEST_TITLE_2);
        Product updated = productService.save( saved );

        assertThat(updated.getTitle(), equalTo(TEST_TITLE_2));
    }

    @Test
    public void testDelete() {
        Product saved = productService.save( createTestEntity() );

        productService.delete( saved.getId() );

        Product one = productService.findOne(saved.getId());
        assertNull( one);
    }

    private Product createTestEntity() {
        return new Product(TEST_TITLE, TEST_DESC, TEST_PRICE);
    }


}