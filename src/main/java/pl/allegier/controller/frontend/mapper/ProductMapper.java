package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Product;

import javax.transaction.Transactional;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@Component
public class ProductMapper implements Mapper<ProductDto,Product>
{
    private static final ModelMapper mapper = new ModelMapper();


    @Transactional
    public Product fromDto(ProductDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return mapper.map(dto, Product.class);
    }

    public ProductDto fromDao(Product dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }
        return mapper.map(dao, ProductDto.class);
    }
}
