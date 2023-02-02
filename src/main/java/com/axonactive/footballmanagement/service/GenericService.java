package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GenericDao;
import com.axonactive.footballmanagement.entities.IGenericEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class GenericService<T extends IGenericEntity> {
    @Inject
    private GenericDao<T> genericDao;

    protected final Class<T> entityClass;

    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected void isRequestEmpty(List<?> objects) {
        if (objects.isEmpty()) {
            throw new CustomException(ErrorConstant.MSG_REQUEST_EMPTY, Response.Status.BAD_REQUEST);
        }
    }

    protected T findById(Object id) {
        T entity = genericDao.findById(id);
        if (entity == null) {
            throw new CustomException(String.format(
                    ErrorConstant.MSG_NOT_FOUND, entityClass.getSimpleName().replace("Entity", "")),
                    Response.Status.NOT_FOUND);
        }
        return entity;
    }

    protected T create(T entity) {
        if (entity.getId() != null)
            throw new CustomException(ErrorConstant.MSG_ID_PROVIDED_IN_CREATE_METHOD, Response.Status.BAD_REQUEST);
        return genericDao.makePersistent(entity);
    }

    protected T update(Object id, T entity) {
        if (!entity.getId().equals(id))
            throw new CustomException(ErrorConstant.MSG_IDPATHPARAM_CONFLICT_IDBODY, Response.Status.BAD_REQUEST);
        findById(id);
        return genericDao.makePersistent(entity);
    }

    protected void delete(Object id) {
        genericDao.makeTransient(findById(id));
    }



}
