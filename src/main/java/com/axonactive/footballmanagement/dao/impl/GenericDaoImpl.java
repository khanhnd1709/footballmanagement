package com.axonactive.footballmanagement.dao.impl;

import com.axonactive.footballmanagement.dao.GenericDao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
    @PersistenceContext(unitName = "football")
    protected EntityManager em;

    protected final Class<T> entityClass;

    protected GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Object id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> c =
                em.getCriteriaBuilder().createQuery(entityClass);
        c.select(c.from(entityClass));
        return em.createQuery(c).getResultList();
    }

    public T makePersistent(T instance) {
        return em.merge(instance);
    }

    public void makeTransient(T instance) {
        em.remove(instance);
    }

}
