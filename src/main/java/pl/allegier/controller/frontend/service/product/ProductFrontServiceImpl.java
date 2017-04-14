package pl.allegier.controller.frontend.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.CrudService;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
@Service
public class ProductFrontServiceImpl extends AbstractFrontService<ProductDto,Product,Integer> implements ProductFrontService {


    @Autowired
    public ProductFrontServiceImpl(Mapper<ProductDto, Product> mapper, CrudService<Product, Integer> crudService) {
        super(mapper, crudService);
    }
}
