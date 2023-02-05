package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.GameEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {StadiumMapper.class})
public interface GameMapper {

    @Mapping(source = "home.name", target = "home")
    @Mapping(source = "away.name", target = "away")
    GameDto toDto(GameEntity gameEntity);

    List<GameDto> toDtos(List<GameEntity> gameEntities);
}
