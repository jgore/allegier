package pl.allegier.controller.frontend.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.Service;
import pl.allegier.model.Order;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@org.springframework.stereotype.Service
public class OrderFrontServiceImpl extends AbstractFrontService<OrderDto,Order,Integer> implements OrderFrontService {

    @Autowired
    public OrderFrontServiceImpl(Mapper<OrderDto, Order> mapper, Service<Order, Integer> crudService) {
        super(mapper, crudService);
    }
}
