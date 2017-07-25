package pl.allegier.controller.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
@Repository
public abstract class JpaDao<E, ID> implements Dao<E, ID> {

    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    public JpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public E findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return em.createQuery("from " + entityClass.getSimpleName()).getResultList();
    }

    @Override
    public Long count() {
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
        findAll().forEach( entity-> em.remove(entity));
    }

}