package pl.allegier.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@Repository
public interface ProductRepository  extends CrudRepository<Product, Integer> {
}
