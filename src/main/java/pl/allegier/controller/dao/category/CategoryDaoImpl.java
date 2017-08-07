package pl.allegier.controller.dao.category;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Category;

import javax.transaction.Transactional;

@Repository("categoryDao")
public class CategoryDaoImpl extends JpaDao<Category,String> implements CategoryDao {

    @Override
    @Transactional
    public Category save(Category entity) {
        Category category = findById(entity.getId());
        if( category != null)
        {
            return category;
        }
        em.persist(entity);
        em.flush();
        return entity;
    }
}
