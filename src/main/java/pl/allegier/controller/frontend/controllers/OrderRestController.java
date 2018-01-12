package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.account.AccountFrontService;
import pl.allegier.controller.frontend.service.order.OrderFrontService;
import pl.allegier.model.Account;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RestController
@RequestMapping("user/orders")
public class OrderRestController extends AbstractRestController<OrderDto, Integer> {

    private final OrderFrontService orderFrontService;

    private final AccountFrontService accountFrontService;

    @Autowired
    public OrderRestController(final OrderFrontService frontService, final AccountFrontService accFrontService) {
        this.orderFrontService = frontService;
        this.accountFrontService = accFrontService;
    }

    @Override
    public final FrontService<OrderDto, Integer> getFrontService() {
        return orderFrontService;
    }

    /**
     * Create order with logged account and on current product
     * @param productId productId
     * @param request web request
     * @return
     */
    @RequestMapping(value = "{productId}", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<OrderDto> create(@PathVariable final Integer productId, final HttpServletRequest request) {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountFrontService.findByLogin(login);

        OrderDto saved = orderFrontService.saveByProduct(productId, account.getId());
        return new ResponseEntity<>(saved, HttpStatus.OK);

    }
}
