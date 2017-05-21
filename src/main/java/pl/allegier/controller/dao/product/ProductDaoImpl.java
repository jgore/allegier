package pl.allegier.controller.dao.product;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("productDao")
public class ProductDaoImpl extends JpaDao<Product,Integer> implements ProductDao {
}
