package com.axonactive.footballmanagement.rest.request;

import lombok.Data;

import javax.ejb.Local;
import java.time.LocalDate;

@Data
public class SeasonRequest {
    private Long id;
    private Long leagueId;
    private LocalDate startDate;
    private LocalDate endDate;
}
