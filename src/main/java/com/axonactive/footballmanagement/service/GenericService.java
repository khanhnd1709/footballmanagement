package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GenericDao;
import com.axonactive.footballmanagement.entities.IGenericEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class GenericService<T extends IGenericEntity> {
    protected final Class<T> entityClass;
    protected final String entityClassName;

    @Inject
    private GenericDao<T> genericDao;

    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.entityClassName = entityClass.getSimpleName().replace("Entity", "");
    }

    public T findById(Object id) {
        return genericDao.findById(id).orElseThrow(() ->
                new CustomException(String.format(ErrorConstant.MSG_NOT_FOUND, entityClassName),
                        Response.Status.NOT_FOUND));
    }

    public List<T> findAll() {
        return genericDao.findAll();
    }

    public T create(T entity) {
        checkNullId(entity);
        genericDao.persist(entity);
        return entity;
    }

    public T update(Object id, T entity) {
        checkIdPathParamEqualIdBody(id, entity);
        findById(id);
        return genericDao.merge(entity);
    }

    public void delete(Object id) {
        genericDao.remove(findById(id));
    }

    protected void checkNullId(T entity) {
        if (entity.getId() != null)
            throw new CustomException(ErrorConstant.MSG_ID_PROVIDED_IN_CREATE_METHOD, Response.Status.BAD_REQUEST);
    }

    protected void checkIdPathParamEqualIdBody(Object id, T entity) {
        if (!entity.getId().equals(id))
            throw new CustomException(ErrorConstant.MSG_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
    }

    protected void checkRequestEmpty(List<?> objects) {
        if (objects.isEmpty())
            throw new CustomException(ErrorConstant.MSG_REQUEST_EMPTY, Response.Status.BAD_REQUEST);
    }
}
