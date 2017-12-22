package pl.allegier.controller.frontend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderProductDto;
import pl.allegier.model.Order;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.Product;

/**
 * Created by Pawel Szczepkowski | GoreIT on 27.10.17.
 */

@Component
public class OrderProductMapper implements Mapper<OrderProductDto, OrderProduct> {

    @Autowired
    private TimestampMapper timestampMapper;

    @Override
    public final OrderProduct toDao(final OrderProductDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("OrderProductDto cannot be null");
        }
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(dto.getId());

        Order order = new Order();
        order.setId(dto.getOrder());
        orderProduct.setOrder(order);

        Product product = new Product();
        product.setId(dto.getProduct());
        orderProduct.setProduct(product);

        orderProduct.setAmount(dto.getAmount());
        timestampMapper.toDao(orderProduct, dto);

        return orderProduct;
    }

    @Override
    public final OrderProductDto toDto(final OrderProduct orderProduct) {
        if (orderProduct == null) {
            throw new IllegalArgumentException("OrderProduct cannot be null");
        }
        OrderProductDto dto = new OrderProductDto();
        dto.setId(orderProduct.getId());
        dto.setOrder(orderProduct.getOrder().getId());
        dto.setProduct(orderProduct.getProduct().getId());
        dto.setAmount(orderProduct.getAmount());
        timestampMapper.toDto(dto, orderProduct);

        return dto;
    }

}
