package pl.allegier.controller.dao.order;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Order;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("orderDao")
public class OrderDaoImpl extends JpaDao<Order,Integer> implements OrderDao {

}
