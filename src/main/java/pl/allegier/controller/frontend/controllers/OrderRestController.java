package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.order.OrderFrontService;
import pl.allegier.controller.frontend.service.product.ProductFrontService;
import pl.allegier.model.OrderProduct;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RestController
@RequestMapping("rest/orders")
public class OrderRestController extends AbstractRestController<OrderDto, Integer> {

    private final OrderFrontService orderFrontService;

    @Autowired
    public OrderRestController(final OrderFrontService frontService) {
        this.orderFrontService = frontService;
    }

    @Override
    public final FrontService<OrderDto, Integer> getFrontService() {
        return orderFrontService;
    }

    @RequestMapping(value = "{productId}", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<OrderDto> create(@PathVariable final Integer productId, final HttpServletRequest request) {

        OrderDto saved = orderFrontService.saveByProduct(productId);
        return new ResponseEntity<>(saved, HttpStatus.OK);

    }
}
