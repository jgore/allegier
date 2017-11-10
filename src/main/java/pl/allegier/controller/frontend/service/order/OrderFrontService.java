package pl.allegier.controller.frontend.service.order;

import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.model.Order;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public interface OrderFrontService extends FrontService<OrderDto,Integer> {
    List<OrderDto> getByAccount(Integer AccountId);
}
