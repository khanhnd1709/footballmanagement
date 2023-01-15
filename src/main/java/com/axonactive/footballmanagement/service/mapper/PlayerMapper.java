package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PlayerMapper {
    @Mapping(source = "playerEntity.id", target = "id")
    @Mapping(source = "playerEntity.name", target = "name")
    @Mapping(source = "playerEntity.dob", target = "dob")
    @Mapping(source = "playerEntity.height", target = "height")
    @Mapping(source = "playerEntity.weight", target = "weight")
    @Mapping(source = "playerEntity.nationalityEnum", target = "nationality")
    @Mapping(source = "playerEntity.footednessEnum", target = "footedness")
    @Mapping(source = "clubEntity.name", target = "clubName")
    PlayerDto toDto(PlayForClubEntity playForClubEntity);

    List<PlayerDto> toDtos(List<PlayForClubEntity> players);
}
