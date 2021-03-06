package pl.allegier.controller.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Order;
import pl.allegier.model.Product;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@Service
public class ProductServiceImpl extends AbstractService<Product, Integer> implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(@Qualifier("productDao") final Dao<Product, Integer> dao) {
        super(dao);
        this.productDao = (ProductDao) dao;
    }

    @Override
    public final List<Product> findByCategory(final int size, final int page, String category) {
        return productDao.findByCategory(size, page, category);
    }

}
