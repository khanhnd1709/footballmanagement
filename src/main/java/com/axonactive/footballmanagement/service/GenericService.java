package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.GenericDao;
import com.axonactive.footballmanagement.entities.IGenericEntity;
import com.axonactive.footballmanagement.rest.exception.CustomException;
import com.axonactive.footballmanagement.rest.exception.errormessages.ErrorConstant;
import com.axonactive.footballmanagement.service.dto.IGenericDto;
import com.axonactive.footballmanagement.service.mapper.GenericMapper;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;


public class GenericService<T extends IGenericEntity, S extends IGenericDto> {
    protected final Class<T> entityClass;
    protected final Class<S> dtoClass;
    protected final String entityClassName;

    @Inject
    protected GenericMapper<T, S> genericMapper;

    @Inject
    private GenericDao<T> genericDao;

    public GenericService(Class<T> entityClass, Class<S> dtoClass) {
        this.entityClass = entityClass;
        this.entityClassName = entityClass.getSimpleName().replace("Entity", "");
        this.dtoClass = dtoClass;
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

    @Transactional(rollbackOn = Exception.class)
    public List<T> create(List<T> entities) {
        entities.forEach(this::create);
        return entities;
    }

    public T update(Object id, T entity) {
        checkIdPathParamEqualIdBody(id, entity);
        findById(id);
        return genericDao.merge(entity);
    }

    public void delete(Object id) {
        genericDao.remove(findById(id));
    }

    public S findById_toDto(Long id) {
        return genericMapper.toDto(findById(id));
    }

    public List<S> findAll_toDto() {
        return genericMapper.toDtos(findAll());
    }

    public List<S> create_toDto(List<T> entities) {
        return genericMapper.toDtos(create(entities));
    }

    public S update_toDto(Long id, T entity) {
        return genericMapper.toDto(update(id, entity));
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
