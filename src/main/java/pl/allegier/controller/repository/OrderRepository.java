package pl.allegier.controller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.allegier.model.Order;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Repository
public interface OrderRepository  extends CrudRepository<Order, Integer> {
}
