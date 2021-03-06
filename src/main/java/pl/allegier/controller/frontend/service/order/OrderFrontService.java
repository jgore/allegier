package pl.allegier.controller.frontend.service.order;

import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.service.FrontService;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public interface OrderFrontService extends FrontService<OrderDto, Integer> {
    List<OrderDto> getByAccount(Integer accountId);

    OrderDto saveByProduct(Integer productId, Integer accountId);
}
