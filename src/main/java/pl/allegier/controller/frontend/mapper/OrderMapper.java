package pl.allegier.controller.frontend.mapper;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto, Order> {

    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private OrderProductMapper orderProductMapper;

    static {
        mapper.addMappings(new OrderMap());
    }

    public OrderMapper() {
    }

    public Order toDao(OrderDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        Order map = mapper.map(dto, Order.class);
        if( dto.getOrderProductDtos() != null) {
            Set<OrderProduct> orderProducts = dto.getOrderProductDtos().stream().
                    map(orderProductDto -> orderProductMapper.toDao(orderProductDto))
                    .collect(Collectors.toSet());
            map.setOrderProducts(orderProducts);
        }


        return mapper.map(dto, Order.class);
    }

    public OrderDto toDto(Order dao) {

        if (dao == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        OrderDto orderDto = mapper.map(dao, OrderDto.class);

        if (dao.getOrderProducts() != null) {

            Set<OrderProductDto> orderProductDtos = dao.getOrderProducts().stream().
                    map(orderProduct -> orderProductMapper.toDto(orderProduct)).collect(Collectors.toSet());

            orderDto.setOrderProductDtos(orderProductDtos);
        }

        return setAccount(dao, orderDto);
    }

    private OrderDto setAccount(Order dao, OrderDto orderDto) {
        if (orderDto.getAccount() != null) {
            orderDto.setAccount(dao.getAccount().getId());
        }
        return orderDto;
    }


    public static class OrderMap extends PropertyMap<Order, OrderDto> {

        @Override
        protected void configure() {
            map().setOrderProductDtos(Sets.newHashSet());
        }

    }
}

