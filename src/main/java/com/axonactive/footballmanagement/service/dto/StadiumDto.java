package com.axonactive.footballmanagement.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StadiumDto implements IGenericDto {
    private Long id;
    private String name;
    private String address;
}
