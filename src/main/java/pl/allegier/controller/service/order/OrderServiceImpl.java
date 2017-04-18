package pl.allegier.controller.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allegier.controller.repository.OrderRepository;
import pl.allegier.model.Order;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public <S extends Order> S save(S order ) {
        return orderRepository.save( order);
    }

    @Override
    public <S extends Order> Iterable<S> save(Iterable<S> Orders) {
        return null;
    }

    @Override
    public Order findOne(Integer id) {
        return orderRepository.findOne( id );
    }

    @Override
    public boolean exists(Integer id) {
        return orderRepository.exists( id );
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> findAll(Iterable<Integer> ids) {
        return orderRepository.findAll( ids );
    }

    @Override
    public long count() {
        return orderRepository.count();
    }

    @Override
    public void delete(Integer id) {
        orderRepository.delete( id );
    }

    @Override
    public void delete(Iterable<? extends Order> orders) {
        orderRepository.delete( orders );
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
