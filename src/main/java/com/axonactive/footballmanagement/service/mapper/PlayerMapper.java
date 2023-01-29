package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PlayerMapper {
    @Mapping(source = "player.id", target = "id")
    @Mapping(source = "player.name", target = "name")
    @Mapping(source = "player.dob", target = "dob")
    @Mapping(source = "player.height", target = "height")
    @Mapping(source = "player.weight", target = "weight")
    @Mapping(source = "player.nationality", target = "nationality")
    @Mapping(source = "player.footedness", target = "footedness")
    @Mapping(source = "team.name", target = "team")
    PlayerDto toDto(TeamPlayedEntity teamPlayedEntity);

    List<PlayerDto> toDtos(List<TeamPlayedEntity> teamPlayedEntities);

    PlayerDto toDto(PlayerEntity playerEntity);



}
