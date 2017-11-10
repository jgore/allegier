package pl.allegier.controller.frontend.service.product;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@Ignore
public class ProductFrontServiceImplTest {

    private static final String TEST_TITLE = "gore";
    private static final String TEST_TITLE_2 = "gore";
    private static final String TEST_DESC = "gore1234";
    private static final BigDecimal TEST_PRICE = BigDecimal.ONE;

    @Autowired
    private ProductFrontService productDtoFrontService;

    @Before
    public void testSetup() {
        productDtoFrontService.deleteAll();
    }

    @Test
    public void testGetOne() {
        ProductDto saved = productDtoFrontService.save(createTestDto() );
        ProductDto one = productDtoFrontService.findOne(saved.getId());

        assertThat( one.getTitle() ,equalTo(TEST_TITLE));
        assertThat( one.getDescription() ,equalTo(TEST_DESC));
        assertThat( one.getPrice() ,equalTo(TEST_PRICE));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        productDtoFrontService.save( createTestDto() );
        productDtoFrontService.save( createTestDto() );

        Iterable<ProductDto> all = productDtoFrontService.findAll();
        List<ProductDto> ProductDtos = Lists.newArrayList(all);

        //TODO FIX
        //assertThat(ProductDtos.size(), equalTo( 2) );

    }

    @Test
    public void testSave() {
        ProductDto save = productDtoFrontService.save( createTestDto() );
        assertThat(save.getTitle(), equalTo(TEST_TITLE));
    }

    @Test
    public void testUpdate() {
        ProductDto save = productDtoFrontService.save( createTestDto() );
        assertThat(save.getTitle(), equalTo(TEST_TITLE));

        save.setTitle(TEST_TITLE_2);
        ProductDto updated = productDtoFrontService.update(save);

        assertThat(updated.getTitle(), equalTo(TEST_TITLE_2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDelete() {
        ProductDto save = productDtoFrontService.save( createTestDto() );

        productDtoFrontService.delete(save.getId());

        ProductDto one = productDtoFrontService.findOne(save.getId());
        assertNull(one);
    }

    private ProductDto createTestDto()
    {
        return new ProductDto(TEST_TITLE, TEST_DESC,TEST_PRICE);
    }

}