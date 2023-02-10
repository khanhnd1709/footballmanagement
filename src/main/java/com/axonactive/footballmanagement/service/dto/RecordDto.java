package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecordDto implements IGenericDto {
    private Integer wins;
    private Integer loses;
    private Integer ties;
    private Integer numberOfGoals;
    private Integer getNumberOfGoalsConceded;
}
