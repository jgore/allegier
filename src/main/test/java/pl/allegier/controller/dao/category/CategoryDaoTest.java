package pl.allegier.controller.dao.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.model.Category;

@Component
public class CategoryDaoTest  extends AbstractDaoTest<Category,String> implements DaoTest<Category,String>{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Dao<Category, String> getRepository() {
        return categoryDao;
    }

    @Override
    public Category createEntity() {
        Category category = new Category();
        category.setId("1234");

        return category;
    }

}