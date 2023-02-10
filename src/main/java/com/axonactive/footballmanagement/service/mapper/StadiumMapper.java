package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.service.GenericService;
import com.axonactive.footballmanagement.service.StadiumService;
import com.axonactive.footballmanagement.service.dto.StadiumDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.inject.Inject;
import java.util.List;

@Mapper(componentModel = "cdi")
public abstract class StadiumMapper implements GenericMapper<StadiumEntity, StadiumDto> {
    @Inject
    private StadiumService stadiumService;

    public StadiumEntity toEntity(Long id) {
        if (id == null)
            return null;
        return stadiumService.findById(id);
    }
}
