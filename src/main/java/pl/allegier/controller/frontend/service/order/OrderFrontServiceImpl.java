package pl.allegier.controller.frontend.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.order.OrderService;
import pl.allegier.model.Order;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@org.springframework.stereotype.Service
public class OrderFrontServiceImpl extends AbstractFrontService<OrderDto,Order,Integer> implements OrderFrontService {

    private final OrderService orderService;

    @Autowired
    public OrderFrontServiceImpl(Mapper<OrderDto, Order> mapper, OrderService crudService) {
        super(mapper, crudService);
        this.orderService = crudService;
    }

    @Override
    public List<OrderDto> getByAccount(Integer accountId) {

        List<Order> daoByAccount = orderService.getByAccount(accountId);

        return daoByAccount.stream().
                map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
