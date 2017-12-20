package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.order.OrderFrontService;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RestController
@RequestMapping("rest/orders")
public class OrderRestController extends AbstractRestController<OrderDto, Integer>{

    private final OrderFrontService orderFrontService;

    @Autowired
    public OrderRestController(final OrderFrontService frontService) {
        this.orderFrontService = frontService;
    }

    @Override
    public final FrontService<OrderDto, Integer> getFrontService() {
        return orderFrontService;
    }
}
