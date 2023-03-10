package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.GameEntity;
import com.axonactive.footballmanagement.service.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {StadiumMapper.class})
public interface GameMapper extends GenericMapper<GameEntity, GameDto> {

}
