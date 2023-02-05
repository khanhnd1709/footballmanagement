package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.GenericDao;
import com.axonactive.footballmanagement.entities.IGenericEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class GenericDaoImpl<T extends IGenericEntity> implements GenericDao<T> {
    protected final Class<T> entityClass;
    @PersistenceContext(unitName = "football")
    protected EntityManager em;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Optional<T> findById(Object id) {
        return Optional.of(em.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> c = em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    @Override
    public void persist(T entity) {
        em.persist(entity);
    }

    @Override
    public T merge(T entity) {
        return em.merge(entity);
    }

    @Override
    public void remove(T entity) {
        em.remove(entity);
    }

}
