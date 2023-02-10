package com.axonactive.footballmanagement.service;

import com.axonactive.footballmanagement.dao.TeamDao;
import com.axonactive.footballmanagement.entities.TeamEntity;
import com.axonactive.footballmanagement.rest.request.TeamRequest;
import com.axonactive.footballmanagement.service.dto.TeamDto;
import com.axonactive.footballmanagement.service.mapper.TeamMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TeamService extends GenericService<TeamEntity, TeamDto> {

    @Inject
    private TeamMapper teamMapper;

    public TeamService() {
        super(TeamEntity.class, TeamDto.class);
    }

    public TeamDto create_toDto(TeamRequest team) {
        return teamMapper.toDto(create(teamMapper.toEntity(team)));
    }

    public TeamDto update_toDto(Long id, TeamRequest team) {
        return teamMapper.toDto(update(id, teamMapper.toEntity(team)));
    }
}
