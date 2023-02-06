package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.service.dto.LeagueDto;
import com.axonactive.footballmanagement.service.dto.SeasonDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface SeasonMapper {
    SeasonDto toDto(SeasonEntity seasonEntity);

    List<SeasonDto> toDtos(List<SeasonEntity> seasonEntities);
}
