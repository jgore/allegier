package pl.allegier.controller.frontend.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.controller.frontend.service.product.ProductFrontService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@RestController
@RequestMapping("rest/products")
@CrossOrigin
public class ProductRestController extends AbstractRestController<ProductDto, Integer> {

    private final ProductFrontService productFrontService;

    @Autowired
    public ProductRestController(final ProductFrontService frontService) {
        this.productFrontService = frontService;
    }

    @Override
    public final FrontService<ProductDto, Integer> getFrontService() {
        return productFrontService;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductDto>> getAll(final HttpServletRequest request,
                                                   @RequestParam(required = false) Integer page,
                                                   @RequestParam(required = false) Integer size,
                                                   @PathVariable String category) {
        if (page == null && size == null) {
            page = 0;
            size = 0;
        }

        List<ProductDto> dtos = Lists.newArrayList(productFrontService.findByCategory(size, page, category));
        dtos.forEach(dto -> {
            dto.setLink(request.getRequestURL().toString());
        });
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
