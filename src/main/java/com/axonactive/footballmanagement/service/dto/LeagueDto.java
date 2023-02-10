package com.axonactive.footballmanagement.service.dto;

import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeagueDto implements IGenericDto {
    private Long id;
    private String name;
    private NationalityEnum nationality;
    private Integer numberOfTeams;
    private Integer maxActivePLayerEachTeam;
    private Integer maxPLayerOneTeamEachGame;
    private Integer maxNumberOfSubstituteEachGame;
}
