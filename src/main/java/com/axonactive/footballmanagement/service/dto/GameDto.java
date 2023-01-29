package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GameDto {
    private String leagueName;
    private String home;
    private String away;
    private List<PlayerDto> players;
    private List<GoalDto> goals;
    private LocalDateTime dateTimeOfGame;
    private String stadiumName;
}