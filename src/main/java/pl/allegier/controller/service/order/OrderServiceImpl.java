package pl.allegier.controller.service.order;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@Service
public class OrderServiceImpl extends AbstractService<Order, Integer> implements OrderService {

    private final OrderDao orderDao;
    private final ProductDao productDao;

    @Autowired
    public OrderServiceImpl(@Qualifier("orderDao") final OrderDao jpaDao, final ProductDao prodDao) {
        super(jpaDao);
        this.orderDao = jpaDao;
        this.productDao = prodDao;
    }

    @Override
    public final List<Order> getByAccount(final Integer accountId) {
        return orderDao.getByAccount(accountId);
    }

    @Override
    public final Order saveByProduct(final Integer productId) {
        if (productId == null) {
            throw new IllegalArgumentException("product Id cannot be null");
        }
        Order order = new Order();
        Product product = productDao.findById(productId);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);

        order.setOrderProducts(Sets.newHashSet(orderProduct));
        save(order);
        return order;
    }
}
