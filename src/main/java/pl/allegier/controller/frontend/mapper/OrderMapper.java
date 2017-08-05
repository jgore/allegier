package pl.allegier.controller.frontend.mapper;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto,Order> {

    private static final ModelMapper mapper = new ModelMapper();

    static {
        mapper.addMappings(new ProductMap());
    }


    public OrderMapper() {
    }

    @Transactional
    public Order fromDto(OrderDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        return mapper.map(dto, Order.class);
    }

    public OrderDto fromDao(Order dao) {

        if (dao == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        OrderDto orderDto = mapper.map(dao, OrderDto.class);


        orderDto = setOrderProductIds(dao, orderDto);

        return setAccount(dao, orderDto);
    }

    private OrderDto setAccount(Order dao, OrderDto orderDto) {
        if (orderDto.getAccountId() != null) {
            orderDto.setAccountId(dao.getAccount().getId());
        }
        return orderDto;
    }

    private OrderDto setOrderProductIds(Order dao, OrderDto orderDto) {

        if (dao.getOrderProducts() != null) {
            Set<Integer> ids = dao.getOrderProducts().stream().map(OrderProduct::getId).collect(Collectors.toSet());
            orderDto.setOrderProducts(ids);
        }

        return orderDto;
    }


    public static class ProductMap extends PropertyMap<Order, OrderDto> {

        @Override
        protected void configure() {

            map().setOrderProducts(Sets.newHashSet());
        }

    }
}

