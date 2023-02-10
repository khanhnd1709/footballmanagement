package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SeasonDto implements IGenericDto {
    private Long id;
    private LeagueDto league;
    private List<SeasonParticipatedDto> teams;
    private List<GameDto> games;
    private LocalDate startDate;
    private LocalDate endDate;
}
