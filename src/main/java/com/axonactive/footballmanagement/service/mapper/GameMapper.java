package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.GameEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface GameMapper {

    @Mapping(source = "home.name", target = "home")
    @Mapping(source = "away.name", target = "away")
    @Mapping(source = "league.name", target = "leagueName")
    @Mapping(source = "stadium.name", target = "stadiumName")
    GameDto toDto(GameEntity gameEntity);

    List<GameDto> toDtos(List<GameEntity> gameEntities);
}
