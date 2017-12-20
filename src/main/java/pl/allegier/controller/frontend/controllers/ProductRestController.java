package pl.allegier.controller.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.product.ProductFrontService;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@RestController
@RequestMapping("rest/products")
@CrossOrigin
public class ProductRestController extends AbstractRestController<ProductDto, Integer>{

    private final ProductFrontService productFrontService;

    @Autowired
    public ProductRestController(final ProductFrontService frontService) {
        this.productFrontService = frontService;
    }

    @Override
    public final FrontService<ProductDto, Integer> getFrontService() {
        return productFrontService;
    }


}
