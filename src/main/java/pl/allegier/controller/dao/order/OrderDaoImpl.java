package pl.allegier.controller.dao.order;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Account;
import pl.allegier.model.Order;
import pl.allegier.model.Product;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("orderDao")
public class OrderDaoImpl extends JpaDao<Order, Integer> implements OrderDao {

    @Override
    public final List<Order> getByAccount(final Integer accountId) {
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.account = ?1", Order.class);
        Account account = em.find(Account.class, accountId);
        query.setParameter("1", account);
        return query.getResultList();
    }

    @Override
    public final List<Order> getOrdersByProduct(final Integer productId) {
        TypedQuery<Order> query = em.createQuery("select o.order from OrderProduct o where o.product = ?1", Order.class);
        Product product = em.find(Product.class, productId);
        query.setParameter("1", product);
        return query.getResultList();
    }
}
