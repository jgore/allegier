package pl.allegier.controller.dao.category;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.model.Category;
import pl.allegier.model.Product;
import pl.allegier.model.enums.MainCategoryName;

import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.greaterThan;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class CategoryDaoTest  extends AbstractDaoTest<Category,String> implements DaoTest<Category,String>{

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Dao<Category, String> getRepository() {
        return categoryDao;
    }

    @After
    public void cleanUp()
    {
        productDao.removeAll();
        categoryDao.removeAll();
    }

    @Test
    public void saveCategoryWithProducts()
    {
        Product product = createProduct();
        Category category= createEntity();
        product.setCategory(category);
        categoryDao.save(category);
        Product save = productDao.save(product);
        Product persisted = productDao.findById(save.getId());
        assertThat(persisted.getTitle(), equalTo(save.getTitle()));
    }

    public Product createProduct()
    {
        Product product = new Product();
        product.setTitle("1234");
        return product;
    }

    @Override
    public Category createEntity() {
        Category category = new Category();
        category.setId("1234");

        return category;
    }

}