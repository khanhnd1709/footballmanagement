package com.axonactive.footballmanagement.service;

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

    public List<TeamDto> create_fromRequest_toDto(List<TeamRequest> teamRequestList) {
        return create_toDto(teamMapper.toEntities(teamRequestList));
    }

    public TeamDto update_fromRequest_toDto(Long id, TeamRequest team) {
        return update_toDto(id, teamMapper.toEntity(team));
    }
}
