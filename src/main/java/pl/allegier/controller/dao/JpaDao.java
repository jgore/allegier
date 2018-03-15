package pl.allegier.controller.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.allegier.model.id.IIdentifable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 *
 * @param <E>  entity to for generic*
 * @param <ID> id for entity
 */
@Repository
public abstract class JpaDao<E extends IIdentifable<ID>, ID> implements Dao<E, ID> {

    /**
     * Class to be used by extending classes - here we have generic
     */
    protected Class<E> entityClass;

    /**
     * Peristancy to DB
     */
    @PersistenceContext
    protected EntityManager em;


    @Autowired
    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public final E findById(final ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<E> findAll(final int size, final int page) {
        if (size == 0 && page == 0) {
            return findAll();
        }

        Query query = em.createQuery("From " + entityClass.getSimpleName());
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    private List<E> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName() + " order by created desc").getResultList();
    }

    @Override
    public final Long count() {
        return (Long) em.
                createQuery("select count(e) from " + entityClass.getSimpleName() + " e").getSingleResult();
    }

    @Override
    @Transactional
    public E save(E entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    @Transactional
    public E update(E entity) {
        em.merge(entity);
        em.flush();
        return entity;
    }

    @Override
    @Transactional
    public E remove(E entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        return entity;
    }

    @Override
    @Transactional
    public void removeAll() {
        findAll().forEach(this::remove);
    }

}