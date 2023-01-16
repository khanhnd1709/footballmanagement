package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {
    private Long id;
    private String leagueName;
    private String club1Name;
    private String club2Name;
    private String matchResult;
    private LocalDate matchStartTime;
}
