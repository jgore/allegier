package pl.allegier.controller.frontend.service.order;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.OrderDto;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class OrderFrontServiceImplTest {

    @Autowired
    private OrderFrontService orderFrontService;

    @Before
    public void testSetup() {
        orderFrontService.deleteAll();
    }

    @Test
    public void testGetOne() {
        OrderDto saved = orderFrontService.save(new OrderDto());
        OrderDto one = orderFrontService.findOne(saved.getId());

     //   assertThat(one.getCreated(), equalTo(TEST_LOGIN_1));
   //     assertThat(one.getPassword(), equalTo(TEST_PASSWORD));
    }

    @Test
    public void testGetAll() throws InterruptedException {
        orderFrontService.save( new OrderDto() );
        orderFrontService.save( new OrderDto() );

        Iterable<OrderDto> all = orderFrontService.findAll();
        List<OrderDto> orderDtos = Lists.newArrayList(all);

        //TODO FIX
        //assertThat(orderDtos.size(), equalTo( 2) );

    }

    @Test
    public void testSave() {
        OrderDto save = orderFrontService.save(new OrderDto( ));

      //  assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));
    }

    @Test
    public void testUpdate() {
        OrderDto save = orderFrontService.save(new OrderDto( ) );

    //    assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

//
        OrderDto updated = orderFrontService.update(save);

      //  assertThat(updated.getLogin(), equalTo(TEST_LOGIN_2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDelete() {
        OrderDto save = orderFrontService.save(new OrderDto());
      //  assertThat(save.getLogin(), equalTo(TEST_LOGIN_1));

        orderFrontService.delete(save.getId());

        OrderDto one = orderFrontService.findOne(save.getId());
        assertNull(one);
    }

}