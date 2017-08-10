package pl.allegier.it.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.product.ProductFrontService;
import pl.allegier.it.ItConfiguration;
import pl.allegier.model.Category;
import pl.allegier.model.enums.MainCategoryName;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    public void createManyProductsIT()
    {
        int length = MainCategoryName.values().length;
        Random random = new Random();

        for( int i=0;i<100;i++)
        {
            ProductDto productDto = new ProductDto(TEST_TITLE + i, TEST_DESC + i, new BigDecimal(i));
            productDto.setCategoryId( MainCategoryName.values()[random.nextInt(length)].name() );
            productDtoFrontService.save( productDto );
        }
    }
}
