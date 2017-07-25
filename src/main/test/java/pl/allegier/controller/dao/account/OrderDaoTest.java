package pl.allegier.controller.dao.account;

import com.google.common.collect.Sets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Satlan on 15.06.17.
 */

@Component
public class OrderDaoTest extends AbstractDaoTest<Order,Integer> implements DaoTest<Order,Integer> {


    public static final String TEST_PROD_TITLE= " TEST _ PROD _ TITLE 1";
    public static final BigDecimal TEST_PROD_PRICE= BigDecimal.valueOf(99.99);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @After
    public  void cleanUp()
    {
        orderDao.removeAll();
        productDao.removeAll();
    }

    @Test
    public void shouldSaveOrderWithRelationToProducts()
    {
        Order order = createOrderWithProducts();

        assertThat( order.getOrderProducts().size(), equalTo(2 ));
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

    public Order createOrderWithProducts()
    {
        Product product1 = createProduct();
        Product product2 = createProduct();

        product1 = productDao.findById(product1.getId());
        product2 = productDao.findById(product2.getId());

        OrderProduct orderProduct1 = createOrderProduct(product1);
        OrderProduct orderProduct2 = createOrderProduct(product2);

        Order order = new Order();
        Set<OrderProduct> products = Sets.newHashSet(orderProduct1, orderProduct2);
        order.setOrderProducts(products);

        orderProduct1.setOrder(order);
        orderProduct2.setOrder(order);

        Order save = orderDao.save(order);

        return orderDao.findById( save.getId() );
    }

    public Order createOrder() {
        return new Order();
    }

    public Product createProduct() {
        Product product = new Product();
        product.setTitle(TEST_PROD_TITLE);
        product.setPrice( TEST_PROD_PRICE);
        return productDao.save(product);
    }

    public OrderProduct createOrderProduct(Product product )
    {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setAmount(1);
        orderProduct.setProduct(product);

        return orderProduct;
    }
}
