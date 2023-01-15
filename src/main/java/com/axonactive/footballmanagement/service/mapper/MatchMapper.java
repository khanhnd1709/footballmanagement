package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.MatchEntity;
import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.service.dto.MatchDto;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MatchMapper {
    //@Mapping(target = "matchResult", expression = "java(if (matchStartTime > new LocalDate()) { \"Match has not started yet\" } else { numberGoalClub1 + \" - \" numberGoalClub2 }")
    //@Mapping(target = "startMatchTime", expression = "java(matchStartTime.toLocalDateTime())")
    @Mapping(source = "club1Entity.name", target = "club1Name")
    @Mapping(source = "club2Entity.name", target = "club2Name")
    @Mapping(source = "leagueEntity.name", target = "leagueName")
    MatchDto toDto(MatchEntity matchEntity);

    List<MatchDto> toDtos(List<MatchEntity> matchEntities);
}
