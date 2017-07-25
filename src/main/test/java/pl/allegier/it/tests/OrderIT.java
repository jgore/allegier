package pl.allegier.it.tests;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.order.OrderFrontService;
import pl.allegier.controller.frontend.service.product.ProductFrontService;
import pl.allegier.it.ItConfiguration;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Pawel Szczepkowski | Satlan on 19.04.17.
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
    private ProductDao productDao;

    @Test
    @Rollback(false)
    public void createManyAccountIT() {
        for (int i = 0; i < 100; i++) {
            Product product = new Product();

            product.setDescription(TEST_PRODUCT);
            product.setTitle(TEST_TITLE);
            product.setPrice(TEST_PRICE);

            product = productDao.save(product);

            Order order = new Order();

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setAmount(1);
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);

            order.setOrderProducts(Sets.newHashSet(orderProduct));

            Order saved = orderDao.save(order);


            assertThat(saved.getOrderProducts().size(), equalTo(1));
        }
    }

}
