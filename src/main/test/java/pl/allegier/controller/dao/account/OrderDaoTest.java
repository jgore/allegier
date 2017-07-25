package pl.allegier.controller.dao.account;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.model.Order;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Satlan on 15.06.17.
 */
public class OrderDaoTest extends AbstractDaoTest<Order,Integer> implements DaoTest<Order,Integer> {


    public static final String TEST_Order_LOGIN= " TEST _ PROD _ TITLE 1";
    public static final String TEST_Order_LOGIN_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private OrderDao orderDao;

    @Before
    public  void setup()
    {
        orderDao.removeAll();
    }

    @Override
    @Test
    public void saveOneTest() {
        Order Order = createOrder();
        Order saved = orderDao.save(Order);

        Order byId = orderDao.findById(saved.getId());

        assertThat( byId.getId(), equalTo( saved.getId()));
    }

    @Override
    @Test
    public void updateOneTest() {
        Order saved = createOrder();

        Order update = orderDao.update(saved);

        assertThat(saved.getId(), equalTo(update.getId()));

    }

    @Override
    @Test
    public void removeOneTest() {
        Order Order = createOrder();
        Order saved = orderDao.save(Order);

        Order removed = orderDao.remove(saved);

        assertThat( orderDao.findById( removed.getId() ),equalTo(  null ));
    }

    @Override
    @Test
    public void findByIdTest() {
        Order Order = createOrder();
        Order save = orderDao.save(Order);
        Order byId = orderDao.findById(save.getId());

        assertThat( save.getId(), equalTo( byId.getId()));
    }

    @Override
    @Test
    public void findAllTest() {
        Order Order1 = createOrder();
        Order Order2 = createOrder();
        orderDao.save(Order1);
        orderDao.save(Order2);

        List<Order> all = orderDao.findAll();

        assertThat( all.size() , equalTo( 2));

    }

    @Override
    @Test
    public void countTest() {
        Order Order1 = createOrder();
        Order Order2 = createOrder();

        orderDao.save(Order1);
        orderDao.save(Order2);

        Long count = orderDao.count();

        assertThat( count , equalTo( 2L));

    }

    @Override
    @Test
    public void removeAllTest() {
        Order Order1 = createOrder();
        Order Order2 = createOrder();
        orderDao.save(Order1);
        orderDao.save(Order2);

        orderDao.removeAll();

        assertThat( orderDao.findAll().size() ,equalTo( 0));
    }

    private Order createOrder() {
        return new Order();
    }
}
