package com.axonactive.footballmanagement.service.dto;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import com.axonactive.footballmanagement.enums.NationalityEnum;
import com.axonactive.footballmanagement.enums.PositionEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto implements IGenericDto {
    private Long id;
    private String name;
    private LocalDate dob;
    private Integer height;
    private Integer weight;
    private FootednessEnum footedness;
    private NationalityEnum nationality;
    private TeamDto team;
    private Integer numberShirt;
    private Long salary;
    private Long transferFee;
    private PositionEnum position;
    private LocalDate attendDate;
    private LocalDate leaveDate;
    private Boolean isActive;
}
