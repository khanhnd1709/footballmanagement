package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.SeasonParticipatedEntity;
import com.axonactive.footballmanagement.service.dto.SeasonParticipatedDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface SeasonParticipatedMapper extends GenericMapper<SeasonParticipatedEntity, SeasonParticipatedDto> {
}
