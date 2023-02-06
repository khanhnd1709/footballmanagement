package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.GoalEntity;
import com.axonactive.footballmanagement.service.dto.GoalDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface GoalMapper {
    @Mapping(source = "scorePlayer.id", target = "socrePlayerId")
    @Mapping(source = "assistPlayer.id", target = "assistPlayerId")
    @Mapping(source = "team.name", target = "teamName")
    @Mapping(source = "timeOfGoal.min", target = "min")
    @Mapping(source = "timeOfGoal.sec", target = "sec")
    @Mapping(source = "timeOfGoal.extraMin", target = "extraMin")
    GoalDto toDto(GoalEntity goalEntity);

    List<GoalDto> toDtos(List<GoalEntity> goalEntities);
}
