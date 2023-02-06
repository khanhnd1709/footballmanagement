package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.IGenericEntity;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T extends IGenericEntity> {
    Optional<T> findById(Object id);
    List<T> findAll();
    void persist(T entity);
    T merge(T entity);
    void remove(T entity);
}