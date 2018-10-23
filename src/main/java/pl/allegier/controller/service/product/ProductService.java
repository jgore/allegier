package pl.allegier.controller.service.product;

import pl.allegier.controller.service.Service;
import pl.allegier.model.Product;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
public interface ProductService extends Service<Product, Integer> {

     List<Product> findByCategory(final int size, final int page, String category);
}
