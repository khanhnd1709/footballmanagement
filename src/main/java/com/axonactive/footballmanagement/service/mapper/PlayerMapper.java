package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamPlayedEntity;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface PlayerMapper {

    PlayerDto toDto(PlayerEntity player);

    List<PlayerDto> toDtos(List<PlayerEntity> player);
}
