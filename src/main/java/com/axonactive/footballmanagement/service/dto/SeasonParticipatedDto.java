package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeasonParticipatedDto implements IGenericDto {
    private Long id;
    private SeasonDto season;
    private TeamDto team;
    private Integer rank;
    private RecordDto record;
}
