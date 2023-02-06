package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.service.dto.StadiumDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface StadiumMapper {
    StadiumDto toDto(StadiumEntity stadiumEntity);

    List<StadiumDto> toDtos(List<StadiumEntity> stadiumEntities);
}
