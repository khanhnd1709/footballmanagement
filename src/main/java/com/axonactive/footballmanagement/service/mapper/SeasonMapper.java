package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.request.SeasonRequest;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.LeagueDto;
import com.axonactive.footballmanagement.service.dto.SeasonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {LeagueMapper.class})
public interface SeasonMapper extends GenericMapper<SeasonEntity, SeasonDto> {
    @Mapping(source = "leagueId", target = "league")
    SeasonEntity toEntity(SeasonRequest season);
}
