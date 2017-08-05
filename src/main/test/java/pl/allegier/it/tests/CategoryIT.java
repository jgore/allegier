package pl.allegier.it.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.it.ItConfiguration;
import pl.allegier.model.Category;
import pl.allegier.model.enums.MainCategoryName;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class CategoryIT {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void createCategories()
    {
        for (MainCategoryName mainCategoryName : MainCategoryName.values()) {
            Category category = new Category();
            category.setId(mainCategoryName.name());
            categoryDao.save(category);
        }
    }
}
