package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.IGenericEntity;

import javax.ejb.Stateless;
import java.util.List;

public interface GenericDao<T extends IGenericEntity> {
    T findById(Object id);
    List<T> findAll();
    T makePersistent(T instance);
    void makeTransient(T instance);
}