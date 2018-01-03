package pl.allegier.controller.service.order;

import pl.allegier.controller.service.Service;
import pl.allegier.model.Order;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public interface OrderService extends Service<Order, Integer> {
    List<Order> getByAccount(final Integer accountId);

    Order saveByProduct(final Integer productId);
}
