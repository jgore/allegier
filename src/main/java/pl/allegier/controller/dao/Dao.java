package pl.allegier.controller.dao;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
public interface Dao<E,ID> {
    E save(E entity);
    E update( E entity);
    E remove(E entity);
    E findById(ID id);
    List<E> findAll();
    Long count();
    void removeAll();
}