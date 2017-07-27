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
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.rest.RestResponse;
import pl.allegier.controller.frontend.service.product.ProductFrontService;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@RestController
@RequestMapping("rest/products")
public class ProductRestController {

    private final ProductFrontService productFrontService;

    @Autowired
    public ProductRestController(ProductFrontService productFrontService) {
        this.productFrontService = productFrontService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getAll() {

        List<ProductDto> ProductDtos = Lists.newArrayList(productFrontService.findAll());

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "all Products", ProductDtos), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getOne(@PathVariable("id") String id) {

        ProductDto ProductDto = productFrontService.findOne(Integer.valueOf(id));

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "one Product", ProductDto), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RestResponse> createPost(@RequestBody ProductDto dto) {

        ProductDto saved = productFrontService.save(dto);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "Product is saved", saved), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<RestResponse> updatePut(@RequestBody ProductDto dto, @PathVariable("id") String id) {

        ProductDto saved = productFrontService.save(dto);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "Account is update", saved), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RestResponse> delete(@RequestBody ProductDto dto, @PathVariable("id") String id) {

        productFrontService.delete(dto.getId());

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK.value(), "Account is deleted", true), HttpStatus.OK);

    }

}
