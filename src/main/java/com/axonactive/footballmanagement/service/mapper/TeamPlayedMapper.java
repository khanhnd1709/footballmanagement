package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PlayerMapper.class, TeamMapper.class})
public interface TeamPlayedMapper extends GenericMapper<TeamPlayedEntity, PlayerDto> {
    TeamPlayedEntity toEntity(TeamPlayedRequest teamPlayedRequest);
    List<TeamPlayedEntity> toEntities(List<TeamPlayedRequest> teamPlayedRequestList);
}
