package pl.allegier.it.tests;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.it.ItConfiguration;
import pl.allegier.model.Account;
import pl.allegier.model.Category;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;
import pl.allegier.model.enums.MainCategoryName;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Pawel Szczepkowski | GoreIT on 19.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ItConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class OrderIT {

    private static final String TEST_PRODUCT = "prod1";
    private static final String TEST_TITLE = "title1";
    private static final BigDecimal TEST_PRICE = BigDecimal.ONE;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private AccountDao accountDao;

    @Test
    @Rollback(false)
    public void createManyOrders() {
        for (int i = 0; i < 100; i++) {
            Account account = saveAccount(i);

            Product product = saveProduct();
            Order saved = saveOrder(product,account);

            assertThat(saved.getOrderProducts().size(), equalTo(1));
        }
    }

    private Order saveOrder(Product product, Account account) {
        Order order = new Order();

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setAmount(1);
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);

        order.setOrderProducts(Sets.newHashSet(orderProduct));
        order.setAccount(account);

        return orderDao.save(order);
    }

    private Product saveProduct() {
        Product product = new Product();
        Random random = new Random();
        int length = MainCategoryName.values().length;
        Category category = categoryDao.findById(MainCategoryName.values()[random.nextInt(length)].name());
        product.setCategory( category );
        product.setDescription(TEST_PRODUCT);
        product.setTitle(TEST_TITLE);
        product.setPrice(TEST_PRICE);

        product = productDao.save(product);
        return product;
    }

    private Account saveAccount(int i) {
        Account account = new Account();
        account.setLogin("1234"+i);
        account.setPassword("9876"+i);

        return accountDao.save(account);
    }
}
