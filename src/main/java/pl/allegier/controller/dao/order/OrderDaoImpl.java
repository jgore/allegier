package pl.allegier.controller.dao.order;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Account;
import pl.allegier.model.Order;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@Repository("orderDao")
public class OrderDaoImpl extends JpaDao<Order,Integer> implements OrderDao {

    @Override
    public List<Order> getByAccount(Integer accountId) {
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.account = ?1", Order.class);
        Account account = em.find(Account.class, accountId);
        query.setParameter("1",account);
        return query.getResultList();
    }
}
