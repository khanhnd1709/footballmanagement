package com.axonactive.footballmanagement.rest.request;

import com.axonactive.footballmanagement.enums.FootednessEnum;
import com.axonactive.footballmanagement.enums.NationalityEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PlayerRequest {
    @NotNull(message = "Player name can't be null")
    private String name;
    private LocalDate dob;
    private NationalityEnum nationality;
    private Integer height;
    private Integer weight;
    private FootednessEnum footedness;
}
