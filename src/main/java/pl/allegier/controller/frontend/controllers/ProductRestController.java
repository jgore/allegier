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
import pl.allegier.controller.frontend.service.product.ProductFrontService;
import pl.allegier.model.Product;

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
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> productDtos = Lists.newArrayList(productFrontService.findAll());

        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDto> getOne(@PathVariable("id") String id) {

        ProductDto productDto = productFrontService.findOne(Integer.valueOf(id));

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ProductDto> createPost(@RequestBody ProductDto dto) {

        ProductDto saved = productFrontService.save(dto);

        return new ResponseEntity<>(saved,HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<ProductDto> updatePut(@RequestBody ProductDto dto, @PathVariable("id") String id) {

        ProductDto saved = productFrontService.save(dto);

        return new ResponseEntity<>(saved,HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Product> delete(@RequestBody ProductDto dto, @PathVariable("id") String id) {

        productFrontService.delete(dto.getId());

        return new ResponseEntity<>( HttpStatus.OK);

    }

}
