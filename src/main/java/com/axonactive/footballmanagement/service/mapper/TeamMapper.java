package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {StadiumMapper.class})
public interface TeamMapper extends GenericMapper<TeamEntity, TeamDto> {

    @Mapping(source = "stadiumId", target = "stadium")
    TeamEntity toEntity(TeamRequest teamRequest);

    List<TeamEntity> toEntities(List<TeamRequest> teamRequest);
}
