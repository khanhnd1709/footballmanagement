package com.axonactive.footballmanagement.service.dto;

import com.axonactive.footballmanagement.enums.NationalityEnum;

public class LeagueDto {
    private Long id;
    private String name;
    private NationalityEnum nationality;
    private Integer numberOfTeams;
    private Integer maxActivePLayerEachTeam;
    private Integer maxPLayerOneTeamEachGame;
    private Integer maxNumberOfSubstituteEachGame;
}
