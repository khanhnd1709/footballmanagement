package com.axonactive.footballmanagement.dao;

import com.axonactive.footballmanagement.entities.PlayerEntity;

public interface GenericDao<T> {
    T merge(T object);
    void persist(T object);
    void remove(T object);
}
