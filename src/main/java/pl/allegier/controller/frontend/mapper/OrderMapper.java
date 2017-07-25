package pl.allegier.controller.frontend.mapper;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto,Order> {

    private static final ModelMapper mapper = new ModelMapper();


    public OrderMapper() {
        mapper.addMappings( new ProductMap() );
    }

    @Transactional
    public Order fromDto(OrderDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("order cannot be null");
        }
        return mapper.map(dto, Order.class);
    }

    public OrderDto fromDao(Order dao) {

        if( dao == null)
        {
            throw new IllegalArgumentException("order cannot be null");
        }
        OrderDto orderDto = mapper.map(dao, OrderDto.class);


        return setOrderProductIds(dao,orderDto);
    }

    private OrderDto setOrderProductIds(Order dao, OrderDto orderDto) {
        Set<Integer> ids = dao.getOrderProducts().stream().map(OrderProduct::getId).collect(Collectors.toSet());
        orderDto.setOrderProducts( ids );

        return orderDto;
    }
}

class ProductMap extends PropertyMap<Order, OrderDto> {

    @Override
    protected  void configure() {

      map().setOrderProducts(Sets.newHashSet() );
    }

}
