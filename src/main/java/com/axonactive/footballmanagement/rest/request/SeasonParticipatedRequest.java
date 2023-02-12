package com.axonactive.footballmanagement.rest.request;

import com.axonactive.footballmanagement.service.dto.RecordDto;
import com.axonactive.footballmanagement.service.dto.SeasonDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import lombok.Data;

@Data
public class SeasonParticipatedRequest {
    private Long id;
    private Long seasonId;
    private Long teamId;
}
