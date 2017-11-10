package pl.allegier.controller.frontend.mapper;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | GoreIT on 27.10.17.
 */

@Component
public class OrderProductMapper implements Mapper<OrderProductDto,OrderProduct> {

    private static final ModelMapper mapper = new ModelMapper();

    static{
        mapper.addMappings( new OrderMap());
    }

    @Override
    public OrderProduct toDao(OrderProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("OrderProductDto cannot be null");
        }
        OrderProduct entity = mapper.map(dto, OrderProduct.class);
        entity.getProduct().setId(dto.getProduct());
        entity.getOrder().setId(dto.getOrder());
        return entity;

    }

    @Override
    public OrderProductDto toDto(OrderProduct entity) {
        if (entity == null) {
            throw new IllegalArgumentException("OrderProduct cannot be null");
        }
        OrderProductDto dto = mapper.map(entity, OrderProductDto.class);
        setOrder(entity,dto);
        setProduct(entity,dto);
        return dto;
    }

    private OrderProductDto setOrder(OrderProduct entity, OrderProductDto dto) {
        if (entity.getOrder() != null) {
            dto.setOrder(entity.getOrder().getId());
        }
        return dto;
    }

    private OrderProductDto setProduct(OrderProduct entity, OrderProductDto dto) {
        if (entity.getProduct() != null) {
            dto.setProduct(entity.getProduct().getId());
        }
        return dto;
    }

    public static class OrderMap extends PropertyMap<OrderProduct, OrderProductDto> {

        @Override
        protected void configure() {
            map().setOrder(null);
            map().setProduct(null);
        }

    }
}
