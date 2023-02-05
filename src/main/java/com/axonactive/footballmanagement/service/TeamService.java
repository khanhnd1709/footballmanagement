package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import com.axonactive.footballmanagement.service.mapper.TeamMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TeamService extends GenericService<TeamEntity> {

    @Inject
    private TeamDao teamDao;

    @Inject
    private TeamMapper teamMapper;

    public TeamService() {
        super(TeamEntity.class);
    }

    public TeamDto findById_ToTeamDto(Long id) {
        return teamMapper.toDto(findById(id));
    }

    public List<TeamDto> findAll_ToTeamDto() {
        return teamMapper.toDtos(teamDao.findAll());
    }

    public TeamDto createTeam(TeamEntity team) {
        return teamMapper.toDto(create(team));
    }

    public TeamDto updateTeam(Long id, TeamEntity team) {
        return teamMapper.toDto(update(id, team));
    }

    public void deleteTeam(Long id) {
        delete(id);
    }

    public void validateGeneralAddRequest(List<?> objects) {
        checkRequestEmpty(objects);
    }
}
