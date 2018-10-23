package pl.allegier.controller.frontend.service.product;

import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.FrontService;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
public interface ProductFrontService extends FrontService<ProductDto, Integer> {
    Iterable<ProductDto> findByCategory(int size, int page, String category);
}
