package pl.allegier.controller.frontend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.model.Order;

import java.util.Date;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class OrderMapperTest implements  MapperTest<OrderDto,Order>{

    @Autowired
    private OrderMapper orderMapper;

    @Test
    @Override
    public void toEntityTest()
    {
        OrderDto dto = new OrderDto();
        dto.setCreated( new Date());
        dto.setUpdated( new Date());
        Order dao = orderMapper.toDao(dto);

        assertThat( dto.getCreated(), equalTo( dao.getCreated()) );
        assertThat( dto.getUpdated(), equalTo( dao.getUpdated()) );
    }

    @Test
    @Override
    public void toDtoTest()
    {
        Order entity = new Order();
        OrderDto dto = orderMapper.toDto(entity);

        assertThat( dto.getCreated(), equalTo( entity.getCreated()) );
        assertThat( dto.getUpdated(), equalTo( entity.getUpdated()) );
    }

}