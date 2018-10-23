package pl.allegier.controller.service;

import pl.allegier.controller.dao.Dao;

/**
 * Created by Pawel Szczepkowski | GoreIT  on 21.05.17.
 */

public class AbstractService<E, ID> implements Service<E, ID> {

    protected final Dao<E, ID> dao;

    public AbstractService(final Dao<E, ID> dao) {
        this.dao = dao;
    }

    @Override
    public final E save(E entity) {
        return dao.save(entity);
    }

    @Override
    public final E update(E entity) {
        return dao.update(entity);
    }

    @Override
    public final E findOne(final ID id) {
        return dao.findById(id);
    }

    @Override
    public final boolean exists(final ID id) {
        return findOne(id) == null;
    }

    @Override
    public final Iterable<E> findAll(final int size, final int page) {
        return dao.findAll(size, page);
    }

    @Override
    public final long count() {
        return dao.count();
    }

    @Override
    public final void delete(final ID id) {
        dao.remove(findOne(id));
    }

    @Override
    public final void deleteAll() {
        dao.removeAll();
    }

    @Override
    public Iterable<E> findByField(int size, int page, String field, String value) {
        return dao.findByField(size, page, field, value);
    }
}
