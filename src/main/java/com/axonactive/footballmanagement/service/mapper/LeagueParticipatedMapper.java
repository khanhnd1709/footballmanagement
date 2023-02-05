package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.SeasonParticipatedEntity;
import com.axonactive.footballmanagement.service.dto.LeagueParticipatedDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface LeagueParticipatedMapper {
    LeagueParticipatedDto toDto(SeasonParticipatedEntity seasonParticipatedEntity);

    List<LeagueParticipatedDto> toDtos(List<SeasonParticipatedEntity> leagueParticipatedEntities);
}
