package pl.allegier.controller.dao.product;

import pl.allegier.controller.dao.Dao;
import pl.allegier.model.Product;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

public interface ProductDao extends Dao<Product, Integer> {
    List<Product> findByCategory(final int size, final int page, String category);

}
