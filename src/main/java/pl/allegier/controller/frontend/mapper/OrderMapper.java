package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.model.Order;

import javax.transaction.Transactional;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto,Order> {

    private static final ModelMapper mapper = new ModelMapper();

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
        return mapper.map(dao, OrderDto.class);
    }
}
