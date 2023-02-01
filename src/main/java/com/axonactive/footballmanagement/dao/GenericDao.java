package com.axonactive.footballmanagement.dao;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public interface GenericDao<T> {
    T findById(Object id);
    List<T> findAll();
    T makePersistent(T instance);
    void makeTransient(T instance);
}