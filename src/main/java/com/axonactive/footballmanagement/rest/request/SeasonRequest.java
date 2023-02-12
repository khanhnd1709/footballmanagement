package com.axonactive.footballmanagement.rest.request;

import lombok.Data;

import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class SeasonRequest {
    private Long id;
    private Long leagueId;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
}
