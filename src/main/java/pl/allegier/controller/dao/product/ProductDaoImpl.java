package pl.allegier.controller.dao.product;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Product;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("productDao")
public class ProductDaoImpl extends JpaDao<Product, Integer> implements ProductDao {

    @Override
    public final List<Product> findAll(final int size, final int page) {

        if (size == 0 && page == 0) {
            return findAll();
        }

        Query query = em.createQuery("From " + entityClass.getSimpleName() + " where state = 'ACTIVE' order by created desc ");
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();

    }

    private List<Product> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName() + " where state = 'ACTIVE' order by created desc ").getResultList();
    }

    @Override
    public List<Product> findByCategory(int size, int page, String category) {
        Query query = em.createQuery("from " + entityClass.getSimpleName() + " where category_id = :category order by created desc");
        query.setParameter("category",category);
        return query.getResultList();
    }
}
