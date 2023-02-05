package com.axonactive.footballmanagement.rest.request;

import javax.ejb.Local;
import java.time.LocalDate;

public class SeasonRequest {
    private Long id;
    private Long leagueId;
    private LocalDate startDate;
    private LocalDate endDate;
}
