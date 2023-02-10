package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto implements IGenericDto {
    private Long id;
    private String name;
    private StadiumDto stadium;
}
