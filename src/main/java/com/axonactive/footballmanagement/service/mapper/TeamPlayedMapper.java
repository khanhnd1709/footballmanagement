package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.rest.request.TeamPlayedRequest;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {PlayerMapper.class, TeamMapper.class})
public interface TeamPlayedMapper {

//    @Mapping(source = "player.id", target = "id")
//    @Mapping(source = "player.name", target = "name")
//    @Mapping(source = "player.dob", target = "dob")
//    @Mapping(source = "player.height", target = "height")
//    @Mapping(source = "player.weight", target = "weight")
//    @Mapping(source = "player.nationality", target = "nationality")
//    @Mapping(source = "player.footedness", target = "footedness")
//    @Mapping(source = "team.id", target = "team.id")
//    @Mapping(source = "team.name", target = "team.name")
    PlayerDto toDto(TeamPlayedEntity teamPlayedEntity);

    List<PlayerDto> toDtos(List<TeamPlayedEntity> teamPlayedEntities);

    TeamPlayedEntity toEntity(TeamPlayedRequest teamPlayedRequest);
}
