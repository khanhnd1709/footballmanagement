package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface TeamMapper {

    TeamDto toDto(TeamEntity team);

    List<TeamDto> toDtos(List<TeamEntity> team);
}
