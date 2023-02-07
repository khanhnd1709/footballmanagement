package com.axonactive.footballmanagement.rest.request;

import com.axonactive.footballmanagement.service.dto.StadiumDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TeamRequest {
    @NotNull(message = "Team name can't be null")
    private String name;
    private Long stadium;
}
