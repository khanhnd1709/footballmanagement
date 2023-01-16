package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.MatchEntity;
import com.axonactive.footballmanagement.entities.PlayForClubEntity;
import com.axonactive.footballmanagement.service.dto.MatchDto;
import com.axonactive.footballmanagement.service.dto.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Mapper(componentModel = "cdi", imports = {LocalDate.class})
public interface MatchMapper {
    @Mapping(target = "matchResult", expression = "java((matchEntity.getMatchStartTime().isAfter(LocalDate.now()))?\"Match has not started yet\":matchEntity.getNumberGoalClub1() + \" - \" + matchEntity.getNumberGoalClub2())")
    @Mapping(source = "club1Entity.name", target = "club1Name")
    @Mapping(source = "club2Entity.name", target = "club2Name")
    @Mapping(source = "leagueEntity.name", target = "leagueName")
    MatchDto toDto(MatchEntity matchEntity);

    List<MatchDto> toDtos(List<MatchEntity> matchEntities);
}
