package pl.allegier.controller.frontend.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.rest.RestResponse;
import pl.allegier.controller.frontend.service.order.OrderFrontService;

import java.util.List;


/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@RestController
@RequestMapping("orders")
public class OrderRestController {

    private final OrderFrontService orderFrontService;

    @Autowired
    public OrderRestController(OrderFrontService orderFrontService) {
        this.orderFrontService = orderFrontService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getAll() {

        List<OrderDto> orderDtos = Lists.newArrayList(orderFrontService.findAll());

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "all orders", orderDtos), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getOne(@PathVariable("id") String id) {

        OrderDto orderDto = orderFrontService.findOne(Integer.valueOf(id));

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "one order", orderDto), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RestResponse> createPost(@RequestBody OrderDto dto) {

        OrderDto saved = orderFrontService.save(dto);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "order is saved", saved), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<RestResponse> updatePut(@RequestBody OrderDto dto, @PathVariable("id") String id) {

        OrderDto saved = orderFrontService.save(dto);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "order is update", saved), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RestResponse> delete(@RequestBody OrderDto dto, @PathVariable("id") String id) {

        orderFrontService.delete(dto.getId());

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "order is deleted", true), HttpStatus.OK);

    }

}
