package pl.allegier.controller.service.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.model.Order;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class OrderServiceImplTest {

    private static final String TEST_LOGIN_1 = "gore";
    private static final String TEST_LOGIN_2 = "gore1234";
    private static final String TEST_PASSWORD = "1234";

    @Autowired
    private OrderService orderService;

    @Before
    public void testSetup()
    {
        orderService.deleteAll();
    }

    @Test
    public void testGetOne() {
        Order saved = orderService.save(new Order() );
        Order one = orderService.findOne(saved.getId());

        assertNotNull( one.getCreated() );
        assertNotNull( one.getUpdated() );
    }

    @Test
    public void testGetAll() throws InterruptedException {
        Order save1 =  orderService.save(new Order() );
        Order save2 =  orderService.save(new Order() );

        Iterable<Order> all = orderService.findAll(Arrays.asList(save1.getId(), save2.getId()));

        //TODO FIX
        //all.iterator().next();

    }

    @Test
    public void testSave() {
        Order one =  orderService.save(new Order() );
        assertNotNull( one.getCreated() );
        assertNotNull( one.getUpdated() );
    }

    @Test
    public void testUpdate() {
        Order save =  orderService.save(new Order() );
        assertNotNull( save.getCreated() );
        assertNotNull( save.getUpdated() );

        save.setUpdated(new Date() );
        Order updated = orderService.save(save);

        assertNotNull( save.getCreated() );
        assertNotNull( save.getUpdated() );
    }

    @Test
    public void testDelete() {
        Order save = orderService.save(new Order() );
        assertNotNull( save.getCreated() );
        assertNotNull( save.getUpdated() );

        orderService.delete( save.getId() );

        Order one = orderService.findOne(save.getId());
        assertNull( one);
    }
}