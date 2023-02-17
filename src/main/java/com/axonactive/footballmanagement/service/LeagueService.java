package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.LeagueDao;
import com.axonactive.footballmanagement.entities.LeagueEntity;
import com.axonactive.footballmanagement.service.dto.LeagueDto;
import com.axonactive.footballmanagement.service.mapper.LeagueMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LeagueService extends GenericService<LeagueEntity, LeagueDto> {

    @Inject
    private LeagueDao leagueDao;

    @Inject
    private LeagueMapper leagueMapper;

    public LeagueService() {
        super(LeagueEntity.class, LeagueDto.class);
    }

}
