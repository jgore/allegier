package pl.allegier.controller.dao.category;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends JpaDao<Category,Integer> implements CategoryDao {
}
