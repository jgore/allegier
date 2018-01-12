package pl.allegier.controller.dao.order;

import com.google.common.collect.Sets;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.model.Account;
import pl.allegier.model.Category;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import java.math.BigDecimal;
import java.security.AccessControlContext;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | GoreIT on 15.06.17.
 */

@Component
public class OrderDaoTest extends AbstractDaoTest<Order, Integer> implements DaoTest<Order, Integer> {

    public static final String TEST_PROD_TITLE = " TEST _ PROD _ TITLE 1";
    public static final BigDecimal TEST_PROD_PRICE = BigDecimal.valueOf(99.99);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public Dao<Order, Integer> getRepository() {
        return orderDao;
    }

    @After
    @Override
    public void cleanUp() {
        orderDao.removeAll();
        productDao.removeAll();
        accountDao.removeAll();
    }

    @Test
    public void shouldGetOrdersByProduct() {
        Order order = createEntity();
        Account account = new Account();
        account.setLogin("12345");
        account.setPassword("12345");
        Account saved = accountDao.save(account);
        order.setAccount(saved);

        OrderProduct orderProduct = new OrderProduct();
        Product product = saveProduct();

        orderProduct.setProduct(product);
        order.setOrderProducts(Sets.newHashSet(orderProduct));

        orderProduct.setOrder( order);

        orderDao.save(order);

        List<Order> byProduct = orderDao.getOrdersByProduct(product.getId());

        assertThat(byProduct.size(), equalTo(1));
    }

    @Test
    public void shouldReturnGetByAccount() {
        Order order = createEntity();
        Account account = new Account();
        account.setLogin("12345");
        account.setPassword("12345");
        Account saved = accountDao.save(account);
        order.setAccount(saved);
        orderDao.save(order);

        List<Order> byAccount = orderDao.getByAccount(order.getAccount().getId());

        assertThat(byAccount.size(), equalTo(1));
    }

    @Test
    public void shouldSaveOrderWithRelationToProducts() {
        Order order = createOrderWithProducts();
        assertThat(order.getOrderProducts().size(), equalTo(2));
    }

    public Order createOrderWithProducts() {
        Product product1 = saveProduct();
        Product product2 = saveProduct();

        product1 = productDao.findById(product1.getId());
        product2 = productDao.findById(product2.getId());

        OrderProduct orderProduct1 = createOrderProduct(product1);
        OrderProduct orderProduct2 = createOrderProduct(product2);

        Order order = new Order();

        Account account = createAccount();
        Account savedAccount = accountDao.save(account);

        Set<OrderProduct> products = Sets.newHashSet(orderProduct1, orderProduct2);
        order.setAccount(savedAccount);
        order.setOrderProducts(products);

        orderProduct1.setOrder(order);
        orderProduct2.setOrder(order);


        Order save = orderDao.save(order);

        return orderDao.findById(save.getId());
    }

    @Override
    public Order createEntity() {
        Order order = new Order();
        Account account = createAccount();
        Account saved = accountDao.save(account);
        order.setAccount(saved);
        return order;
    }

    public Product saveProduct() {
        Category category = createCategory();
        Category saved = categoryDao.save(category);
        category = categoryDao.findById(saved.getId());


        Product product = new Product();
        product.setTitle(TEST_PROD_TITLE);
        product.setPrice(TEST_PROD_PRICE);
        product.setCategory(category);
        return productDao.save(product);
    }

    public Category createCategory() {
        Category category = new Category();
        category.setId("1234");

        return category;
    }

    public Account createAccount()
    {
        Account account = new Account();
        account.setLogin("1234");
        account.setPassword("1234");

        return account;
    }

    public OrderProduct createOrderProduct(Product product) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setAmount(1);
        orderProduct.setProduct(product);

        return orderProduct;
    }
}
