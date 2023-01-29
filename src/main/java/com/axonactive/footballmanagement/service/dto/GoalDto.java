package com.axonactive.footballmanagement.service.dto;

import com.axonactive.footballmanagement.enums.GoalTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GoalDto {
    private Long socrePlayerId;
    private GoalTypeEnum goalType;
    private Long assistPlayerId;
    private String teamName;
    private Integer min;
    private Integer sec;
    private Integer extraMin;
}
