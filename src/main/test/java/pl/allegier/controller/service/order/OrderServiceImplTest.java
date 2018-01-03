package pl.allegier.controller.service.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.allegier.controller.dao.order.OrderDao;
import pl.allegier.controller.dao.order.OrderDaoImpl;
import pl.allegier.controller.dao.product.ProductDao;
import pl.allegier.controller.dao.product.ProductDaoImpl;
import pl.allegier.model.Order;
import pl.allegier.model.Product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pawel Szczepkowski | GoreIT on 18.04.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderDao orderDao = mock( OrderDaoImpl.class);
    @Mock
    private  ProductDao productDao = mock( ProductDaoImpl.class);
    @InjectMocks
    private OrderServiceImpl orderService ;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderServiceImpl(orderDao,productDao);
        Product testProduct = new Product();
        when( productDao.findById(any()) ).thenReturn( testProduct )  ;
        Order order = new Order();
        when( orderDao.save(any()) ).thenReturn( order )  ;
    }

    @Test
    public void saveByProduct() {
        orderService.saveByProduct(1);
        verify(orderDao,times(1)).save(any()) ;
    }

}