package pl.allegier.controller.frontend.mapper;

import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

import javax.transaction.Transactional;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Component
public class ProductMapper implements Mapper<ProductDto, Product> {

    @Autowired
    private AllegierModelMapper mapper;

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Override
    public Product toDao(final ProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Product map = mapper.map(dto, Product.class);
        setCategory(dto, map);
        return map;
    }

    @Override
    public final ProductDto toDto(final Product dao) {
        if (dao == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        mapper.createTypeMap(Product.class, ProductDto.class);
        TypeMap<Product, ProductDto> typeMap = mapper.getTypeMap(Product.class, ProductDto.class);
        typeMap.addMappings(mapper -> mapper.skip(ProductDto::setCategory));
        ProductDto map = mapper.map(dao, ProductDto.class);
        setCategory(dao, map);
        return map;

    }


    private void setCategory(final ProductDto dto, final Product entity) {
        if (dto.getCategory() != null) {
            entity.setCategory(categoryDao.findById(dto.getCategory()));
        }
    }

    private void setCategory(final Product entity, final ProductDto dto) {
        if (entity.getCategory() != null) {
            dto.setCategory(entity.getCategory().getId());
        }
    }

}

