package pl.allegier.controller.service;

import pl.allegier.controller.dao.Dao;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

public abstract class AbstractService<E,ID> implements Service<E,ID> {

    private final Dao<E,ID> dao;

    public AbstractService(Dao<E,ID> dao) {
        this.dao = dao;
    }

    @Override
    public E save(E entity) {
        return dao.save( entity);
    }

    @Override
    public E update(E entity) {
        return dao.update(entity);
    }

    @Override
    public E findOne(ID id) {
        return dao.findById(id);
    }

    @Override
    public boolean exists(ID id) {
        return findOne(id)  == null ;
    }

    @Override
    public Iterable<E> findAll() {
        return dao.findAll();
    }

    @Override
    public long count() {
       return dao.count();
    }

    @Override
    public void delete(ID id) {
        dao.remove( findOne( id) );
    }

    @Override
    public void deleteAll() {
        dao.removeAll();
    }
}
