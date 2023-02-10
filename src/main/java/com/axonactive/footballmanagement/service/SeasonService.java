package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.SeasonDao;
import com.axonactive.footballmanagement.dao.StadiumDao;
import com.axonactive.footballmanagement.entities.SeasonEntity;
import com.axonactive.footballmanagement.rest.request.SeasonRequest;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.SeasonDto;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import com.axonactive.footballmanagement.service.mapper.SeasonMapper;
import com.axonactive.footballmanagement.service.mapper.StadiumMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SeasonService extends GenericService<SeasonEntity, SeasonDto> {
    @Inject
    private SeasonMapper seasonMapper;
    public SeasonService() {
        super(SeasonEntity.class, SeasonDto.class);
    }

    public SeasonDto create_toDto(SeasonRequest season) {
        return seasonMapper.toDto(create(seasonMapper.toEntity(season)));
    }

    public SeasonDto update_toDto(Long id, SeasonRequest season) {
        return seasonMapper.toDto(update(id, seasonMapper.toEntity(season)));
    }
}