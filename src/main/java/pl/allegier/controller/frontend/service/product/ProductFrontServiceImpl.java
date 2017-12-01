package pl.allegier.controller.frontend.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.mapper.ProductMapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.Service;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@org.springframework.stereotype.Service
public class ProductFrontServiceImpl extends AbstractFrontService<ProductDto,Product,Integer> implements ProductFrontService {


    @Autowired
    public ProductFrontServiceImpl(Mapper<ProductDto,Product> productMapper, Service<Product, Integer> crudService) {
        super(productMapper, crudService);
    }
}
