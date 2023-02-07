package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.service.StadiumService;
import com.axonactive.footballmanagement.service.dto.StadiumDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.inject.Inject;
import java.util.List;

@Mapper(componentModel = "cdi")
public abstract class StadiumMapper {
    @Inject
    private StadiumService stadiumService;
    public abstract StadiumDto toDto(StadiumEntity stadiumEntity);

    public abstract List<StadiumDto> toDtos(List<StadiumEntity> stadiumEntities);

    public StadiumEntity toEntity(Long id) {
        return stadiumService.findById(id);
    }
}
