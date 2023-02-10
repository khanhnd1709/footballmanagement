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

    public LeagueDto findById_ToLeagueDto(Long id) {
        return leagueMapper.toDto(findById(id));
    }

    public List<LeagueDto> findAll_ToLeagueDto() {
        return leagueMapper.toDtos(leagueDao.findAll());
    }

    public LeagueDto createLeague(LeagueEntity league) {
        return leagueMapper.toDto(create(league));
    }

    public LeagueDto updateLeague(Long id, LeagueEntity league) {
        return leagueMapper.toDto(update(id, league));
    }

    public void deleteLeague(Long id) {
        delete(id);
    }
}
