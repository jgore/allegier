package pl.allegier.controller.dao.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.model.Category;
import pl.allegier.model.Product;
import pl.allegier.model.enums.MainCategoryName;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Pawel Szczepkowski | GoreIT on 15.06.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class ProductDaoTest extends AbstractDaoTest<Product,Integer> implements DaoTest<Product,Integer> {

    public static final String TEST_PROD_TITLE_1 = " TEST _ PROD _ TITLE 1";
    public static final String TEST_PROD_TITLE_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Dao<Product, Integer> getRepository() {
        return productDao;
    }

    @Test
    public void testGetByCategory()
    {
        Product entity = createEntity();
        productDao.save(entity);
        List<Product> byCategory = productDao.findByCategory(20, 0, MainCategoryName.ELEKTRONIKA.name());
        assertTrue( byCategory.size()  > 0) ;
    }


    @Override
    public Product createEntity() {
        Product product = new Product(TEST_PROD_TITLE_1, TEST_DESCRIPTION, TEST_PRICE);
        Category category = createCategory();
        Category save = categoryDao.save(category);
        product.setCategory(save);
        return product;
    }

    public Category createCategory()
    {
        Category category = new Category();
        category.setId(MainCategoryName.ELEKTRONIKA.name());

        return category;
    }

}