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
public class PlayerDto {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private Integer height;
    private Integer weight;
    private FootednessEnum footedness;
    private NationalityEnum nationality;
    private String clubName;
    private Integer numberShirt;
    private Long salary;
    private Long transferValue;
    private PositionEnum positionEnum;
}
