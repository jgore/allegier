package pl.allegier.controller.dao.order;

import pl.allegier.controller.dao.Dao;
import pl.allegier.model.Order;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

public interface OrderDao extends Dao<Order, Integer> {

    /**
     * get order by account
     * @param accountId
     * @return
     */
    List<Order> getByAccount(Integer accountId);

    /**
     * get orders containing product
     * @param productId
     * @return
     */
    List<Order> getOrdersByProduct(final Integer productId);
}
