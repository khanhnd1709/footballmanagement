package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.GameEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import org.mapstruct.Mapper;

import java.util.List;

public interface GenericMapper<T, S> {
    S toDto(T entity);

    List<S> toDtos(List<T> entities);
}