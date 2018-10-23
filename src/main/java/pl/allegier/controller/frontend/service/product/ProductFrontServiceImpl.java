package pl.allegier.controller.frontend.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.Service;
import pl.allegier.controller.service.product.ProductService;
import pl.allegier.model.Product;
import pl.allegier.model.enums.ProductState;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
@org.springframework.stereotype.Service
public class ProductFrontServiceImpl extends AbstractFrontService<ProductDto, Product, Integer> implements ProductFrontService {

    private ProductService service;

    @Autowired
    public ProductFrontServiceImpl(final Mapper<ProductDto, Product> productMapper, final Service<Product, Integer> crudService) {
        super(productMapper, crudService);
        this.service = (ProductService) crudService;
    }

    @Override
    public final void delete(final Integer id) {
        Product product = service.findOne(id);
        product.setState(ProductState.DELETED);
        service.update(product);
    }

    @Override
    public List<ProductDto> findByCategory(int size, int page, String category) {
        return service.findByCategory(size, page, category).stream().
                map(mapper::toDto).
                collect(Collectors.toList());
    }
}
