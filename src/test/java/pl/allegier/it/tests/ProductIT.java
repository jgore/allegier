package pl.allegier.it.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.product.ProductFrontService;
import pl.allegier.it.ItConfiguration;

import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class ProductIT {

    private static final String TEST_TITLE = "title";
    private static final String TEST_DESC = "desc";

    @Autowired
    private ProductFrontService productDtoFrontService;

    @Test
    public void createManyProductsTest()
    {
        for( int i=0;i<1000;i++)
        {
            productDtoFrontService.save( new ProductDto(TEST_TITLE +i, TEST_DESC+i, new BigDecimal(i)) );
        }
    }
}
