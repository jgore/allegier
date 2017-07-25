package pl.allegier.controller.frontend.mapper;

import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.OrderDto;
import pl.allegier.model.Order;
import pl.allegier.model.Product;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Component
public class OrderMapper implements Mapper<OrderDto,Order> {

    private static final ModelMapper mapper = new ModelMapper();
  /*  {
        mapper.addMappings(new ProductMap() );
    }*/

    public OrderMapper() {
    }

    @Transactional
    public Order fromDto(OrderDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("order cannot be null");
        }
        return mapper.map(dto, Order.class);
    }

    public OrderDto fromDao(Order dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("order cannot be null");
        }
        return mapper.map(dao, OrderDto.class);
    }
}

/*class ProductMap extends PropertyMap<Order, OrderDto> {

    @Override
    protected  void configure() {
        if( source.getOrderProducts()!= null) {

            Set<Integer> idsProduct = new HashSet<>();
            for (Product product : source.getOrderProducts()) {
               idsProduct.add( product.getId( ) );
            }

            Set<Integer> idsProduct = source.getOrderProducts().
                    stream().
                    map(Product::getId).
                    collect(Collectors.toSet());
            map().setOrderProducts( idsProduct );
        }
    }

}*/

