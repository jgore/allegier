package pl.allegier.controller.service;

import pl.allegier.controller.frontend.dto.OrderDto;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */
public interface Service<E, ID> {

    E save(E entity);

    E update(E entity);

    E findOne(ID entity);

    boolean exists(ID entity);

    Iterable<E> findAll(int size, int page);

    long count();

    void delete(ID entity);

    void deleteAll();

}