package pl.allegier.controller.frontend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Satlan on 27.10.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class OrderProductMapperTest implements MapperTest<OrderProductDto, OrderProduct>{

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Test
    public void toDtoTest()
    {
        //given
        Order order = new Order();
        order.setId(1);
        Product product = new Product();
        product.setId(2);

        OrderProduct entity = new OrderProduct();
        entity.setId(0);
        entity.setOrder(order);
        entity.setProduct(product);
        entity.setAmount(1);
        //when
        OrderProductDto dto = orderProductMapper.toDto(entity);

        assertThat( dto.getId(),equalTo( 0 ) );
        assertThat( dto.getProduct(),equalTo( 2 ) );
        assertThat( dto.getOrder(),equalTo( 1 ) );
        assertThat( dto.getAmount(),equalTo( 1 ) );

    }

    @Override
    @Test
    public void toEntityTest() {
        //given

        OrderProductDto dto  = new OrderProductDto();
        dto.setId(0);
        dto.setProduct(1);
        dto.setOrder(2);
        dto.setAmount(3);
        //when
        OrderProduct entity = orderProductMapper.toDao(dto);
        entity.setId(0);
        //then
        assertThat( entity.getId(),equalTo( 0 ) );
        assertThat( entity.getProduct().getId(),equalTo( 1 ) );
        assertThat( entity.getOrder().getId(),equalTo( 2) );
        assertThat( entity.getAmount(),equalTo(  3) );
    }
}