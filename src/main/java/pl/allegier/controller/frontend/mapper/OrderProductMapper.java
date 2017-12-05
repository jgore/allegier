package pl.allegier.controller.frontend.mapper;

import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.model.OrderProduct;

/**
 * Created by Pawel Szczepkowski | GoreIT on 27.10.17.
 */

@Component
public class OrderProductMapper implements Mapper<OrderProductDto, OrderProduct> {

    private AllegierModelMapper mapper;

    @Autowired
    public OrderProductMapper(final AllegierModelMapper mapper) {
        this.mapper = mapper;
        TypeMap<OrderProduct, OrderProductDto> typeMap = mapper.getTypeMap(OrderProduct.class, OrderProductDto.class);
    }


    @Override
    public final OrderProduct toDao(final OrderProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("OrderProductDto cannot be null");
        }
        OrderProduct entity = mapper.map(dto, OrderProduct.class);
        entity.getProduct().setId(dto.getProduct());
        entity.getOrder().setId(dto.getOrder());
        return entity;

    }

    @Override
    public final OrderProductDto toDto(final OrderProduct entity) {
        if (entity == null) {
            throw new IllegalArgumentException("OrderProduct cannot be null");
        }
        OrderProductDto dto = mapper.map(entity, OrderProductDto.class);
        setOrder(entity, dto);
        setProduct(entity, dto);
        return dto;
    }

    private OrderProductDto setOrder(final OrderProduct entity, final OrderProductDto dto) {
        if (entity.getOrder() != null) {
            dto.setOrder(entity.getOrder().getId());
        }
        return dto;
    }

    private OrderProductDto setProduct(final OrderProduct entity, final OrderProductDto dto) {
        if (entity.getProduct() != null) {
            dto.setProduct(entity.getProduct().getId());
        }
        return dto;
    }


}
