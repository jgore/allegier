package pl.allegier.controller.frontend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Component
public class ProductMapper implements Mapper<ProductDto, Product> {

    @Autowired
    private TimestampMapper timestampMapper;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public final Product toDao(final ProductDto dto) {
        Product product = new Product();
        product.setCategory(categoryDao.findById(dto.getCategory()));
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());

        timestampMapper.toDao(product, dto);
        return product;
    }

    @Override
    public final ProductDto toDto(final Product product) {
        ProductDto dto = new ProductDto();
        dto.setCategory(product.getCategory().getId());
        dto.setId(product.getId());
        dto.setDescription(product.getDescription());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        timestampMapper.toDto(dto, product);
        return dto;
    }
}

