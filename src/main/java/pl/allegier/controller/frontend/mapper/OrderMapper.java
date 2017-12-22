package pl.allegier.controller.frontend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.model.Account;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto, Order> {

    @Autowired
    private TimestampMapper timestampMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public final Order toDao(final OrderDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        Order order = new Order();
        order.setId(dto.getId());
        Account account = new Account();
        account.setId(dto.getAccount());
        order.setAccount(account);

        if (dto.getOrderProductDtos() != null) {
            Set<OrderProduct> orderProducts = dto.getOrderProductDtos().stream().
                    map(orderProductDto -> orderProductMapper.toDao(orderProductDto)).
                    collect(Collectors.toSet());
            order.setOrderProducts(orderProducts);
        }
        timestampMapper.toDao(account, dto);

        return order;
    }

    @Override
    public final OrderDto toDto(final Order entity) {
        if (entity == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());

        if (entity.getAccount() != null) {
            dto.setAccount(entity.getAccount().getId());
        }

        if (entity.getOrderProducts() != null) {
            Set<OrderProductDto> orderProductDtos = entity.getOrderProducts().stream().
                    map(orderProduct -> orderProductMapper.toDto(orderProduct)).
                    collect(Collectors.toSet());
            dto.setOrderProductDtos(orderProductDtos);
        }

        timestampMapper.toDto(dto, entity);
        return dto;
    }
}

