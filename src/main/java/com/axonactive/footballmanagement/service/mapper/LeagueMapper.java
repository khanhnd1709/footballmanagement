package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.service.dto.LeagueDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface LeagueMapper {

    LeagueDto toDto(LeagueEntity leagueDetailEntity);

    List<LeagueDto> toDtos(List<LeagueEntity> leagueEntities);
}
