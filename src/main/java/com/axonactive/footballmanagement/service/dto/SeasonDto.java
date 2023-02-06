package com.axonactive.footballmanagement.service.dto;

import java.time.LocalDate;
import java.util.List;

public class SeasonDto {
    private Long id;
    private List<LeagueParticipatedDto> teams;
    private List<GameDto> games;
    private LocalDate startDate;
    private LocalDate endDate;
}
