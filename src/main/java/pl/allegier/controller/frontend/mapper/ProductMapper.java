package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Auction;
import pl.allegier.model.Product;

import javax.transaction.Transactional;
import java.util.HashSet;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@Component
public class ProductMapper implements Mapper<ProductDto,Product>
{
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private CategoryDao categoryDao;

    static {
        mapper.addMappings(new ProductMap());
    }


    @Transactional
    public Product toDao(ProductDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Product map = mapper.map(dto, Product.class);
        setCategory(dto, map);
        return map;
    }

    public ProductDto toDto(Product dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("Product cannot be null");
        }
        ProductDto map = mapper.map(dao, ProductDto.class);
        setCategory(dao, map);
        return map;

    }

    public static class ProductMap extends PropertyMap<Product, ProductDto> {

        @Override
        protected void configure() {
            map().setCategory(null);
        }

    }

    private void setCategory(ProductDto dto, Product entity) {
        if( dto.getCategory() != null) {
            entity.setCategory(categoryDao.findById(dto.getCategory()));
        }
    }

    private void setCategory(Product entity, ProductDto dto)
    {
        if( entity.getCategory() != null) {
            dto.setCategory(entity.getCategory().getId()) ;
        }
    }

}

