package pl.allegier.controller.dao.product;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Product;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("productDao")
public class ProductDaoImpl extends JpaDao<Product, Integer> implements ProductDao {

    @Override
    public final List<Product> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName() + " where state = 'ACTIVE' order by created desc ")
                .getResultList();
    }



}
