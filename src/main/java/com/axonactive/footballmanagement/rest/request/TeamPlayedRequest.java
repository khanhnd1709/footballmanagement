package com.axonactive.footballmanagement.rest.request;

import com.axonactive.footballmanagement.entities.PlayerEntity;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.enums.PositionEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
public class TeamPlayedRequest {

    private Long id;

    @NotNull
    private Long playerId;

    @NotNull
    private Long teamId;

    @Max(99)
    @PositiveOrZero
    private Integer numberShirt;

    @PositiveOrZero
    private Long salary;

    @PositiveOrZero
    private Long transferFee;

    @Enumerated(value = EnumType.STRING)
    private PositionEnum position;

    @NotNull
    private LocalDate attendDate;

    private LocalDate leaveDate;

    private Boolean isActive = false;
}
