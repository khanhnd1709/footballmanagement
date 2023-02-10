package com.axonactive.footballmanagement.service.mapper;

import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.entities.StadiumEntity;
import com.axonactive.footballmanagement.service.LeagueService;
import com.axonactive.footballmanagement.service.StadiumService;
import com.axonactive.footballmanagement.service.dto.LeagueDto;
import org.mapstruct.Mapper;

import javax.inject.Inject;
import java.util.List;

@Mapper(componentModel = "cdi")
public abstract class LeagueMapper implements GenericMapper<LeagueEntity, LeagueDto> {
    @Inject
    private LeagueService leagueService;

    public LeagueEntity toEntity(Long id) {
        if (id == null)
            return null;
        return leagueService.findById(id);
    }
}