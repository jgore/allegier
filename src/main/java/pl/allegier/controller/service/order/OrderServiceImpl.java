package pl.allegier.controller.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Order;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Service
public class OrderServiceImpl  extends AbstractService<Order,Integer> implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(@Qualifier("orderDao") OrderDao jpaDao) {
        super(jpaDao);
        this.orderDao = jpaDao;
    }

    @Override
    public List<Order> getByAccount(Integer accountId) {
        return orderDao.getByAccount( accountId) ;
    }
}
